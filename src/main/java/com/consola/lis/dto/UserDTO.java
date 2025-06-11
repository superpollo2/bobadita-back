package com.consola.lis.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class UserDTO {
    private String  nombres;
    private String  apellidos;
    private String  cedula;
    private String  fechaNacimiento;
    private String  ciudadNacimiento;
    private String  ciudadResidencia;
    private String  estadoCivil;
}
