package com.sephora.commons.exception;

/** Exception Framework which can be used to handle service error scenarios */
public class SephoraServiceException extends SephoraException {

  public SephoraServiceException(SephoraErrorCode errorCode) {
    super(errorCode);
  }

  public SephoraServiceException(String message, String errorCode) {
    super(message, errorCode);
  }

  public SephoraServiceException(Throwable original, String errorCode) {
    super(original, errorCode);
  }
}
