package com.sephora.commons.exception;

/** Exception Framework which can be used to handle gateway timeout scenarios */
public class SephoraGatewayTimeoutException extends SephoraException {

  public SephoraGatewayTimeoutException(SephoraErrorCode errorCode) {
    super(errorCode);
  }

  public SephoraGatewayTimeoutException(String message, String errorCode) {
    super(message, errorCode);
  }

  public SephoraGatewayTimeoutException(Throwable original, String errorCode) {
    super(original, errorCode);
  }
}
