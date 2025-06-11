package com.consola.lis.controller;


import com.consola.lis.constans.EndpointConstant;
import com.consola.lis.controller.service.ApiRestService;
import com.consola.lis.exception.AlreadyExistsException;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(EndpointConstant.ENDPOINT_REGISTER)
@RequiredArgsConstructor
public class RegisterRequestController {

    private final ApiRestService apiRestService;
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createNewUser(@RequestBody JsonNode jsonNode) {
        try {
            apiRestService.registerNewUser(jsonNode); // Esto llama al servicio que guarda el nuevo usuario
            return ResponseEntity.status(HttpStatus.CREATED).build();  // Si todo sale bien, devuelve un 201 Created
        } catch (AlreadyExistsException ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error interno en el servidor: " + ex.getMessage());
        }
    }
}
