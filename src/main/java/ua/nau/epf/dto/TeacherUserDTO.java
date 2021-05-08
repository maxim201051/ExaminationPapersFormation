package ua.nau.epf.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeacherUserDTO {
    private TeacherInfoCardDTO teacher;
    private UserDTO user;
}
