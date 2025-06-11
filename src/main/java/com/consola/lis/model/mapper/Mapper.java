package com.consola.lis.model.mapper;



import com.consola.lis.dto.UserDTO;
import com.consola.lis.model.entity.UserEntity;
import org.springframework.stereotype.Service;

@Service
public class Mapper {

    public UserEntity mapToEntity(UserDTO userDTO){
        return UserEntity.builder()
                .apellidos(userDTO.getApellidos())
                .estadoCivil(userDTO.getEstadoCivil())
                .cedula(userDTO.getCedula())
                .ciudadResidencia(userDTO.getCiudadResidencia())
                .ciudadNacimiento(userDTO.getCiudadNacimiento())
                .nombres(userDTO.getNombres())
                .fechaNacimiento(userDTO.getFechaNacimiento())
                .build();

    }
}
