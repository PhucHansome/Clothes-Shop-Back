package com.clothes.springbootapi.controller.api;

import com.clothes.springbootapi.domain.dto.RoleDTO;
import com.clothes.springbootapi.domain.dto.UserDTO;
import com.clothes.springbootapi.domain.entity.JwtResponse;
import com.clothes.springbootapi.domain.entity.Role;
import com.clothes.springbootapi.domain.entity.User;
import com.clothes.springbootapi.exception.DataInputException;
import com.clothes.springbootapi.exception.EmailExistsException;
import com.clothes.springbootapi.service.jwt.JwtService;
import com.clothes.springbootapi.service.role.RoleService;
import com.clothes.springbootapi.service.user.IUserService;
import com.clothes.springbootapi.utils.AppUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/api/auth")
public class AuthRestController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private IUserService userService;

    @Autowired
    private AppUtil appUtil;

    @PostMapping("/token")
    public ResponseEntity<?> getUserToken() {
        try {
            String emailUser = appUtil.getPrincipal();
            User user = userService.findByUsername(emailUser).get();

            return new ResponseEntity<>(user.toUserDTO(), HttpStatus.OK);
        } catch (Exception e) {
            UserDTO userDTO = new UserDTO();
            userDTO.setUsername("anonymousUser");
            return new ResponseEntity<>(userDTO, HttpStatus.ACCEPTED);
        }
    }

    @GetMapping("/token/user")
    public ResponseEntity<?> getUserTokenn() {
        try {
            String emailUser = appUtil.getPrincipal();
            User  user = userService.findByUsername(emailUser).get();

            return new ResponseEntity<>(user.toUserDTO(), HttpStatus.OK);
        } catch (Exception e) {
            throw new DataInputException("Tài Khoản Không Hợp Lệ!!!");
        }
    }

    @GetMapping("/token/role")
    public ResponseEntity<?> getRoleUser() {
        try {
            String emailUser = appUtil.getPrincipal();
            User user = userService.findByUsername(emailUser).get();

            RoleDTO roleDTO = user.getRole().toRoleDTO();

            return new ResponseEntity<>(roleDTO, HttpStatus.OK);
        } catch (Exception e) {
            throw new DataInputException("Tài Khoản Không Hợp Lệ!!!");
        }
    }


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtService.generateTokenLogin(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        User currentUser = userService.getByUsername(user.getUsername());

        JwtResponse jwtResponse = new JwtResponse(
                jwt,
                currentUser.getId(),
                userDetails.getUsername(),
                currentUser.getUsername(),
                userDetails.getAuthorities()
        );

        ResponseCookie springCookie = ResponseCookie.from("JWT", jwt)
                .httpOnly(false)
                .secure(false)
                .path("/")
                .maxAge(24 * 60 * 60 * 1000)
                .domain("localhost")
//                .domain("ajax-bank-location-jwt.herokuapp.com")
//                .domain("bank-transaction.azurewebsites.net")
                .build();

        System.out.println(jwtResponse);

        return ResponseEntity
                .ok()
                .header(HttpHeaders.SET_COOKIE, springCookie.toString())
                .body(jwtResponse);

    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserDTO userDTO, BindingResult bindingResult) {

        if (bindingResult.hasErrors())
            return appUtil.mapErrorToResponse(bindingResult);

        Boolean existsByUsername = userService.existsByUsername(userDTO.getUsername());

        if (existsByUsername) {
            throw new EmailExistsException("Account already exists");
        }

        Optional<Role> optRole = roleService.findById(userDTO.getRole().getId());

        if (!optRole.isPresent()) {
            throw new DataInputException("Invalid account role");
        }

        try {

            return new ResponseEntity<>(userService.save(userDTO.toUser()).toUserDTO(), HttpStatus.CREATED);
        } catch (DataIntegrityViolationException e) {
            throw new DataInputException("Account information is not valid, please check the information again");
        }
    }

    @PostMapping("/register/client")
    public ResponseEntity<?> registerClient(@RequestBody User user) {
        Optional<User> currentUser = userService.findByUsername(user.getUsername());
        if (currentUser.isPresent()) {
            throw new DataInputException("Email exists");
        }

        try {
            User userRegisterDTO = userService.save(user);
            return new ResponseEntity<>(userRegisterDTO, HttpStatus.OK);
        } catch (Exception e) {
            throw new DataInputException(e.getMessage());
        }
    }
}
