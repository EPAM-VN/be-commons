package com.sephora.commons.exception.advice;


import com.sephora.commons.constant.SephoraExceptionFrameworkConstant;
import com.sephora.commons.exception.dto.ExceptionResponse;
import com.sephora.commons.exception.dto.SephoraError;
import com.sephora.commons.exception.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.support.WebExchangeBindException;
import org.springframework.web.server.ServerWebInputException;

import java.util.*;
import java.nio.file.AccessDeniedException;
import java.time.Instant;
import java.util.stream.Collectors;

@Order(Ordered.LOWEST_PRECEDENCE)
@ControllerAdvice
public class SephoraExceptionAdvice {

  private static final Logger LOGGER = LoggerFactory.getLogger(SephoraExceptionAdvice.class);

  @ExceptionHandler(SephoraValidationException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ResponseEntity<ExceptionResponse> handleImValidationException(SephoraValidationException e) {
    return handleSephoraException(e, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(SephoraAuthorizationException.class)
  @ResponseStatus(HttpStatus.UNAUTHORIZED)
  public ResponseEntity<ExceptionResponse> handleImAuthorizationException(
      SephoraAuthorizationException e) {
    return handleSephoraException(e, HttpStatus.UNAUTHORIZED);
  }

  @ExceptionHandler(SephoraForbiddenException.class)
  @ResponseStatus(HttpStatus.FORBIDDEN)
  public ResponseEntity<ExceptionResponse> handleImForbiddenException(SephoraForbiddenException e) {
    return handleSephoraException(e, HttpStatus.FORBIDDEN);
  }

  @ExceptionHandler(AccessDeniedException.class)
  @ResponseStatus(HttpStatus.FORBIDDEN)
  public ResponseEntity<ExceptionResponse> handleAccessDeniedException(AccessDeniedException e) {
    return handleSephoraException(
        new SephoraForbiddenException(e, SephoraExceptionFrameworkConstant.ACCESS_DENIED_ERROR_CODE),
        HttpStatus.FORBIDDEN);
  }

  @ExceptionHandler(SephoraResourceNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public ResponseEntity<ExceptionResponse> handleImResourceNotFoundException(
      SephoraResourceNotFoundException e) {
    return handleSephoraException(e, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(SephoraConflictException.class)
  @ResponseStatus(HttpStatus.CONFLICT)
  public ResponseEntity<ExceptionResponse> handleImConflictException(SephoraConflictException e) {
    return handleSephoraException(e, HttpStatus.CONFLICT);
  }

  @ExceptionHandler(SephoraRequestTimeoutException.class)
  @ResponseStatus(HttpStatus.REQUEST_TIMEOUT)
  public ResponseEntity<ExceptionResponse> handleImRequestTimeoutException(
      SephoraRequestTimeoutException e) {
    return handleSephoraException(e, HttpStatus.REQUEST_TIMEOUT);
  }

  @ExceptionHandler(SephoraUnProcessableException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ResponseEntity<ExceptionResponse> handleImUnProcessableException(
      SephoraUnProcessableException e) {
    return handleSephoraException(e, HttpStatus.UNPROCESSABLE_ENTITY);
  }

  @ExceptionHandler(SephoraInternalServerException.class)
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public ResponseEntity<ExceptionResponse> handleImInternalServerException(
      SephoraInternalServerException e) {
    return handleSephoraException(e, HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler(SephoraServiceException.class)
  @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
  public ResponseEntity<ExceptionResponse> handleImServiceException(SephoraServiceException e) {
    return handleSephoraException(e, HttpStatus.SERVICE_UNAVAILABLE);
  }

  @ExceptionHandler(SephoraGatewayTimeoutException.class)
  @ResponseStatus(HttpStatus.GATEWAY_TIMEOUT)
  public ResponseEntity<ExceptionResponse> handleImGatewayTimeoutException(
      SephoraGatewayTimeoutException e) {
    return handleSephoraException(e, HttpStatus.GATEWAY_TIMEOUT);
  }

  @ExceptionHandler(SephoraNoContentException.class)
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public ResponseEntity<ExceptionResponse> handleImNoContentException(SephoraNoContentException e) {
    return ResponseEntity.noContent().build();
  }

  @ExceptionHandler(SephoraNotImplementedException.class)
  @ResponseStatus(HttpStatus.NOT_IMPLEMENTED)
  public ResponseEntity<ExceptionResponse> handleImNotImplementedException(
      SephoraNotImplementedException e) {
    return handleSephoraException(e, HttpStatus.NOT_IMPLEMENTED);
  }

  @ExceptionHandler(ServerWebInputException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ResponseEntity<ExceptionResponse> handleTypeMismatchException(ServerWebInputException e) {
    LOGGER.error(e.getMessage(), e);
    String errorMessage = "Error input";
    return handleSephoraException(
        new SephoraValidationException(
            errorMessage, SephoraExceptionFrameworkConstant.SERVER_WEB_INPUT_EXCEPTION),
        HttpStatus.BAD_REQUEST);
  }

  private ResponseEntity<ExceptionResponse> handleSephoraException(SephoraException e, HttpStatus status) {
    LOGGER.error(e.getMessage(), e);
    ExceptionResponse response =
        ExceptionResponse.builder()
            .timestamp(Instant.now())
            .status(status.value())
            .reason(status.getReasonPhrase())
            .message(e.getMessage())
            .errorCode(e.getErrorCode())
            .traceId(MDC.get(SephoraExceptionFrameworkConstant.TRACE_ID))
            .build();
    return ResponseEntity.status(status).body(response);
  }

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(WebExchangeBindException.class)
  public ResponseEntity<ExceptionResponse> handleJSRValidationException(
      WebExchangeBindException e) {
    LOGGER.error(e.getMessage(), e);
    List<SephoraError> errors =
        e.getFieldErrors().stream()
            .map(fieldError -> new SephoraError(fieldError.getField(), fieldError.getDefaultMessage()))
            .collect(Collectors.toList());

    ExceptionResponse response =
        ExceptionResponse.builder()
            .timestamp(Instant.now())
            .status(HttpStatus.BAD_REQUEST.value())
            .reason(HttpStatus.BAD_REQUEST.getReasonPhrase())
            .message("Model validation failed")
            .errorCode(SephoraExceptionFrameworkConstant.MODEL_VALIDATION_FAILED)
            .traceId(MDC.get(SephoraExceptionFrameworkConstant.TRACE_ID))
            .errors(errors)
            .build();
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
  }

  @ExceptionHandler(SephoraFieldsException.class)
  public ResponseEntity<ExceptionResponse> handleImFieldsException(SephoraFieldsException e) {
    LOGGER.error(e.getMessage(), e);
    ExceptionResponse response =
        ExceptionResponse.builder()
            .timestamp(Instant.now())
            .status(e.getHttpStatus().value())
            .reason(e.getHttpStatus().getReasonPhrase())
            .message(e.getMessage())
            .errorCode(e.getErrorCode())
            .traceId(MDC.get(SephoraExceptionFrameworkConstant.TRACE_ID))
            .errors(e.getErrors())
            .build();
    return ResponseEntity.status(e.getHttpStatus()).body(response);
  }

  /** Handle all other unhandled exception */
  @ExceptionHandler(Exception.class)
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public ResponseEntity<ExceptionResponse> handleDefaultException(Exception e) {
    LOGGER.error(e.getMessage(), e);
    ExceptionResponse response =
        ExceptionResponse.builder()
            .timestamp(Instant.now())
            .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
            .reason(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase())
            .message("Failed to process request")
            .errorCode(SephoraExceptionFrameworkConstant.SEPHORA_DEFAULT_ERROR_CODE)
            .traceId(MDC.get(SephoraExceptionFrameworkConstant.TRACE_ID))
            .build();
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
  }
}
