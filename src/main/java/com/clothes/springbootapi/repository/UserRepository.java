package com.clothes.springbootapi.repository;

import com.clothes.springbootapi.domain.dto.UserDTO;
import com.clothes.springbootapi.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User getByUsername(String username);

    Optional<User> findByUsername(String username);


    @Query("SELECT NEW com.clothes.springbootapi.domain.dto.UserDTO (" +
            "u.id, " +
            "u.username" +
            ") " +
            "FROM User u " +
            "WHERE u.username = ?1"
    )
    Optional<UserDTO> findUserDTOByUsername(String username);

    @Query("SELECT NEW com.clothes.springbootapi.domain.dto.UserDTO (" +
            "u.id, " +
            "u.username, " +
            "u.password , " +
            "u.role" +
            ") " +
            "FROM User u " +
            "WHERE u.username = ?1 "
    )
    Optional<UserDTO> findUserDTOFullByUsername(String username);

    Boolean existsByUsername(String username);

    @Query("SELECT NEW com.clothes.springbootapi.domain.dto.UserDTO (u.id,u.username,u.password,u.role) FROM User u WHERE u.id = ?1")
    Optional<UserDTO> findUserDTOById(Long id);

}
