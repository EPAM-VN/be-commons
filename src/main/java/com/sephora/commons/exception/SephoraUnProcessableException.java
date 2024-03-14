package com.sephora.commons.exception;

/** Exception Framework which can be used to handle unprocessable entity related scenarios */
public class SephoraUnProcessableException extends SephoraException {

  public SephoraUnProcessableException(SephoraErrorCode errorCode) {
    super(errorCode);
  }

  public SephoraUnProcessableException(String message, String errorCode) {
    super(message, errorCode);
  }

  public SephoraUnProcessableException(Throwable original, String errorCode) {
    super(original, errorCode);
  }
}
