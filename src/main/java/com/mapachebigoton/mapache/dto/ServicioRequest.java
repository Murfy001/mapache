package com.mapachebigoton.mapache.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
@Data
public class ServicioRequest {
    @NotBlank
    @Size(max = 50)
    String descripcion;

    @NotBlank
    Long costo;
}
