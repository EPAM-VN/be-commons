package com.sephora.commons.exception;

/** Exception Framework which can be used to handle resource not found scenarios */
public class SephoraResourceNotFoundException extends SephoraException {
  public SephoraResourceNotFoundException(SephoraErrorCode errorCode, Object... messageParams) {
    super(errorCode, messageParams);
  }
}
