package ua.nau.epf.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentUserDTO {
    private StudentInfoCardDTO student;
    private UserDTO user;
}
