package com.sephora.commons.exception;

/** Exception Framework which can be used to handle data validation scenarios */
public class SephoraValidationException extends SephoraException {

  public SephoraValidationException(SephoraErrorCode errorCode) {
    super(errorCode);
  }

  public SephoraValidationException(String message, String errorCode) {
    super(message, errorCode);
  }

  public SephoraValidationException(Throwable original, String errorCode) {
    super(original, errorCode);
  }
}
