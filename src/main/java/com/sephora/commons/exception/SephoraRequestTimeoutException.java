package com.sephora.commons.exception;

/** Exception Framework which can be used to handle request timeout scenarios */
public class SephoraRequestTimeoutException extends SephoraException {

  public SephoraRequestTimeoutException(SephoraErrorCode errorCode) {
    super(errorCode);
  }

  public SephoraRequestTimeoutException(String message, String errorCode) {
    super(message, errorCode);
  }

  public SephoraRequestTimeoutException(Throwable original, String errorCode) {
    super(original, errorCode);
  }
}
