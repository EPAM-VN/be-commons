package com.sephora.commons.exception.dto;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SephoraError implements Serializable {
  private String fieldName;
  private String message;
}
