package com.sephora.commons.exception.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
public class SephoraError implements Serializable {
  private String fieldName;
  private String message;
}
