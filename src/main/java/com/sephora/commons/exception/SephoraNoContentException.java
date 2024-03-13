package com.sephora.commons.exception;

/** Exception Framework which can be used to handle no content and/or no data scenarios */
public class SephoraNoContentException extends SephoraException {

  public SephoraNoContentException(SephoraErrorCode errorCode) {
    super(errorCode);
  }

  public SephoraNoContentException(String message, String errorCode) {
    super(message, errorCode);
  }

  public SephoraNoContentException(Throwable original, String errorCode) {
    super(original, errorCode);
  }
}
