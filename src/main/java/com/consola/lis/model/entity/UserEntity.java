package com.consola.lis.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="userCom")
public class UserEntity{

    private String  nombres;
    private String  apellidos;
    @Id
    private String  cedula;
    private String  fechaNacimiento;
    private String  ciudadNacimiento;
    private String  ciudadResidencia;
    private String  estadoCivil;
}
