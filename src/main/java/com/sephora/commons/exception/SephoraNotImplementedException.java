package com.sephora.commons.exception;

/** Exception Framework which can be used to handle not implemented scenarios */
public class SephoraNotImplementedException extends SephoraException {

  public SephoraNotImplementedException(SephoraErrorCode errorCode) {
    super(errorCode);
  }

  public SephoraNotImplementedException(String message, String errorCode) {
    super(message, errorCode);
  }

  public SephoraNotImplementedException(Throwable original, String errorCode) {
    super(original, errorCode);
  }
}
