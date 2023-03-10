package com.clothes.springbootapi.domain.dto;

import com.clothes.springbootapi.domain.entity.Role;
import com.clothes.springbootapi.domain.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
public class UserDTO {

    private Long id;


    @NotBlank(message = "The username is required")
    @Email(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$",message = "The email address is invalid")
    @Size(max = 50, message = "The length of username must be between 5 and 50 characters")
    private String username;

    @NotBlank(message = "The password is required")
    @Size(max = 30, message = "Maximum password length 30 characters")
    private String password;

//    @NotBlank(message = "The password is required")
//    @Pattern(regexp = "^[0][1-9][0-9]{8}$|^[+84][1-9][0-9]{10}$",message = "The phone is valid!")
//    private String phone;
//
//    private boolean isActive;

//    private String urlImage;

    private RoleDTO role;

//    @Valid
//    private LocationRegionDTO locationRegion;


    public UserDTO(Long id, String username) {
        this.id = id;
        this.username = username;
    }

    public UserDTO(Long id, String username, String password , Role role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role.toRoleDTO();
    }


    public User toUser() {
        return new User()
                .setId(id)
                .setUsername(username)
                .setPassword(password)
                .setRole(role.toRole());
    }

//    @Override
//    public boolean supports(Class<?> aClass) {
//        return UserDTO.class.isAssignableFrom(aClass);
//    }
//    @Override
//    public void validate(Object target, Errors errors) {
//        UserDTO userDTO = (UserDTO) target;
//
//        String fullNameCheck = userDTO.getFullName();
//        String emailCheck = userDTO.getUserName();
//        String passwordCheck = userDTO.getPassword();
//        String phoneCheck = userDTO.getPhone();

//        if ((emailCheck.trim()).isEmpty()) {
//            errors.rejectValue("email", "email.isEmpty", "Vui L??ng Nh???p Email Ng?????i D??ng");
//            return;
//        }
//
//        if ((fullNameCheck.trim().isEmpty())){
//            errors.rejectValue("fullName", "fullName.isEmpty", "Vui L??ng Nh???p T??n Ng?????i D??ng");
//            return;
//        }
//
//        if ((passwordCheck.trim()).isEmpty()) {
//            errors.rejectValue("password", "password.isEmpty", "Vui L??ng Nh???p M???t Kh???u Ng?????i D??ng");
//            return;
//        }
//
//        if ((phoneCheck.trim()).isEmpty()) {
//            errors.rejectValue("phone", "phone.isEmpty", "Vui L??ng Nh???p S??? ??i???n Tho???i Ng?????i D??ng");
//            return;
//        }
//
//        if ((fullNameCheck.length() < 3 || fullNameCheck.length() > 255)) {
//            errors.rejectValue("fullName", "fullName.length", "T??n T??? 3 ?????n 255 K?? T???");
//            return;
//        }
//
//        if ((emailCheck.length() > 255)) {
//            errors.rejectValue("email", "fullName.length", "Email T???i ??a 255 K?? T???");
//            return;
//        }
//
//        if (passwordCheck.length() > 50) {
//            errors.rejectValue("password", "password.length", "M???t Kh???u T???i ??a 50 K?? T???");
//            return;
//        }
//
//        if (!emailCheck.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,3}$")) {
//            errors.rejectValue("email", "email.matches", "Email Nh???p V??o Kh??ng H???p L???");
//            return;
//        }
//
////        if (!passwordCheck.matches("(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^*])(?!.*['\"`]).{6,}")) {
////            errors.rejectValue("password", "password.matches", "M???t Kh???u Nh???p V??o Kh??ng H???p L???");
////            return;
////        }
//
//        if (!phoneCheck.matches("^(0?)(3[2-9]|5[6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])[0-9]{7}$")){
//            errors.rejectValue("phone", "phone.matches", "S??? ??i???n Tho???i Nh???p V??o Kh??ng H???p L???");
//            return;
//        }

}
