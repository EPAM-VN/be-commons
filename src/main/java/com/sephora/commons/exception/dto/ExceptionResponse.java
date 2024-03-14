package com.sephora.commons.exception.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.io.Serializable;
import java.time.Instant;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@Builder
public class ExceptionResponse implements Serializable {

  private Instant timestamp;
  private List<SephoraError> errors;
  private int status;
  private String reason;
  private String message;
  private String errorCode;
  private String traceId;
}
