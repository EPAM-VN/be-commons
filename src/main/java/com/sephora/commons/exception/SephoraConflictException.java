package com.sephora.commons.exception;

/** Exception Framework which can be used to handle duplication and/or conflict scenarios */
public class SephoraConflictException extends SephoraException {

  public SephoraConflictException(SephoraErrorCode errorCode, Object... messageParams) {
    super(errorCode, messageParams);
  }
}
