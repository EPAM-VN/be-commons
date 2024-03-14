package com.sephora.commons.exception;

/** Exception Framework which can be used to handle access forbidden scenarios */
public class SephoraForbiddenException extends SephoraException {

  public SephoraForbiddenException(SephoraErrorCode errorCode) {
    super(errorCode);
  }

  public SephoraForbiddenException(String message, String errorCode) {
    super(message, errorCode);
  }

  public SephoraForbiddenException(Throwable original, String errorCode) {
    super(original, errorCode);
  }
}
