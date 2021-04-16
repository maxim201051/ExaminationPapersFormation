package ua.nau.epf.entity.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.userdetails.UserDetails;
import ua.nau.epf.util.Validator;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;
    @Pattern(regexp = Validator.USERNAME_REGEX, message = "Username do not match regex " + Validator.USERNAME_REGEX)
    @Column(nullable = false, unique = true)
    private String username;
    @Pattern(regexp = Validator.PASSWORD_REGEX, message = "Password should contain at least one uppercase letter, " +
            "one lowercase letter, one digit and be between 8 and 32 characters long")
    @Column(nullable = false)
    private String password;
    private String profilePictureFileName;
    @ElementCollection(fetch = FetchType.LAZY)
    private List<Role> authorities;
    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    @Column(nullable = false)
    private boolean enabled;
}