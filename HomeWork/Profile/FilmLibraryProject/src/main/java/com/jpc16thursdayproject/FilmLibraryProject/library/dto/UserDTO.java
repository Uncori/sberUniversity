package com.jpc16thursdayproject.FilmLibraryProject.library.dto;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class UserDTO extends GenericDTO {
    private String login;
    private String password;
    private LocalDate birthDate;
    private String firstName;
    private String middleName;
    private String lastName;
    private String phone;
    private String address;
    private String email;
    private RoleDTO role;
    private List<Long> userOrders;
    private boolean isDeleted;
    private String changePasswordToken;
}
