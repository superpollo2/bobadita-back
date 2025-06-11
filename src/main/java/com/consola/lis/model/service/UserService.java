package com.consola.lis.model.service;


import com.consola.lis.dto.UserDTO;
import com.consola.lis.exception.AlreadyExistsException;
import com.consola.lis.model.mapper.Mapper;
import com.consola.lis.model.repository.UserRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
@Log
public class UserService {
    private final ObjectMapper objectMapper;
    private final UserRepository userRepository;
    private final Mapper mapper;


    public void saveNewUser(JsonNode body) {
        var userDTO = objectMapper.convertValue(body, UserDTO.class);
        var userEntity = mapper.mapToEntity(userDTO);

        if (userRepository.existsByCedula(userEntity.getCedula())) {
            log.info("Fallo en crear usuario");
            throw new AlreadyExistsException(HttpStatus.CONFLICT.name(), HttpStatus.CONFLICT, "fallo en la creación del usuario");
        }
        userRepository.save(userEntity);


    }

}
