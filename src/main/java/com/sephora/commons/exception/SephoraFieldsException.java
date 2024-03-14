package com.sephora.commons.exception;

import com.sephora.commons.exception.dto.SephoraError;
import java.util.List;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class SephoraFieldsException extends SephoraException {

  private final List<SephoraError> errors;
  private final HttpStatus httpStatus;

  public SephoraFieldsException(
      HttpStatus httpStatus,
      List<SephoraError> errors,
      SephoraErrorCode errorCode,
      Object... messageParams) {
    super(errorCode, messageParams);
    this.errors = errors;
    this.httpStatus = httpStatus;
  }
}
