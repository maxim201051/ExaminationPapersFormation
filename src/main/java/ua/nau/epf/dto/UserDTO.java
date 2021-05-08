package ua.nau.epf.dto;

import lombok.Getter;
import lombok.Setter;
import ua.nau.epf.util.Validator;

import javax.validation.constraints.Pattern;

@Getter
@Setter
public class UserDTO {
    private Long id;
    @Pattern(regexp = Validator.USERNAME_REGEX, message = "Username do not match regex " + Validator.USERNAME_REGEX)
    private String username;
    @Pattern(regexp = Validator.PASSWORD_REGEX, message = "Password should contain at least one uppercase letter, " +
            "one lowercase letter, one digit and be between 8 and 32 characters long")
    private String password;
    private String profilePictureFileName;
    private String authority;
    private Boolean enabled;
}
