package org.acme;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record Post(
  @NotNull
  Number userId,
  
  Number id,

  @NotBlank
  String title,

  @NotBlank
  String body
) {
  
}
