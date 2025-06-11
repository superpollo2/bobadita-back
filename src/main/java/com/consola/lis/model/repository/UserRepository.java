package com.consola.lis.model.repository;

import com.consola.lis.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {


   Boolean existsByCedula(String username);
}
