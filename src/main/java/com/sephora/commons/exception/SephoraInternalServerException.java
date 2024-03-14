package com.sephora.commons.exception;

/** Exception Framework which can be used to handle internal server error scenarios */
public class SephoraInternalServerException extends SephoraException {

  public SephoraInternalServerException(SephoraErrorCode errorCode) {
    super(errorCode);
  }

  public SephoraInternalServerException(SephoraErrorCode errorCode, Object... messageParams) {
    super(errorCode, messageParams);
  }

  public SephoraInternalServerException(String message, String errorCode) {
    super(message, errorCode);
  }

  public SephoraInternalServerException(Throwable original, String errorCode) {
    super(original, errorCode);
  }
}
