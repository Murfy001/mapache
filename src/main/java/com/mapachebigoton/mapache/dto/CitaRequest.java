package com.mapachebigoton.mapache.dto;

import java.sql.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CitaRequest {
    @NotBlank
    @Size(max = 50)
    String nombre;
    @NotBlank
    Date fecha;
    @NotBlank
    String hora;
    @NotBlank
    Integer idCliente;
    @NotBlank
    Integer idBarbero;
    @NotBlank
    Integer idServicio;

}
