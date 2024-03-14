package com.sephora.commons.exception;

import java.util.Arrays;

public class SephoraException extends RuntimeException {
  private final String message;
  private final String errorCode;

  protected SephoraException(SephoraErrorCode errorCode, Object... messageParams) {
    this(errorCode.getErrorMessage(), errorCode.getErrorCode(), messageParams);
  }

  protected SephoraException(String message, String errorCode, Object... messageParams) {
    this.message =
        Arrays.asList(messageParams).isEmpty() ? message : String.format(message, messageParams);
    this.errorCode = errorCode;
  }

  protected SephoraException(Throwable original, String errorCode) {
    super(original);
    this.message = original.getMessage();
    this.errorCode = errorCode;
  }

  @Override
  public String getMessage() {
    return message;
  }

  public String getErrorCode() {
    return errorCode;
  }
}
