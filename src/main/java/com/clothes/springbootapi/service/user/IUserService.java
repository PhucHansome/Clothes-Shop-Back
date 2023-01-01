package com.clothes.springbootapi.service.user;

import com.clothes.springbootapi.domain.dto.UserDTO;
import com.clothes.springbootapi.domain.entity.User;
import com.clothes.springbootapi.service.IGeneralService;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

public interface IUserService extends IGeneralService<User>, UserDetailsService {

    User getByUsername(String username);

    Optional<UserDTO> findUserDTOById(Long id);


    Optional<User> findByUsername(String username);

    Optional<UserDTO> findUserDTOByUsername(String username);

    Boolean existsByUsername(String username);

    Optional<UserDTO> findUserDTOFullByUsername(String username);
}
