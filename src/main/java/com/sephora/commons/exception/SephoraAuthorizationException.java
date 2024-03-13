package com.sephora.commons.exception;

/** Exception Framework which can be used to handle unauthorized access scenarios */
public class SephoraAuthorizationException extends SephoraException {

  public SephoraAuthorizationException(SephoraErrorCode errorCode) {
    super(errorCode);
  }

  public SephoraAuthorizationException(String message, String errorCode) {
    super(message, errorCode);
  }

  public SephoraAuthorizationException(Throwable original, String errorCode) {
    super(original, errorCode);
  }
}
