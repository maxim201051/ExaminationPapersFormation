package ua.nau.epf.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.nau.epf.entity.user.User;
import ua.nau.epf.util.Validator;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"first_name", "last_name", "patronymic"})})
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;
    @Pattern(regexp = Validator.NAME_REGEX, message = "First name do not match regex " + Validator.NAME_REGEX)
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Pattern(regexp = Validator.NAME_REGEX, message = "Last name do not match regex " + Validator.NAME_REGEX)
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Pattern(regexp = Validator.NAME_REGEX, message = "Patronymic do not match regex " + Validator.NAME_REGEX)
    @Column(nullable = false)
    private String patronymic;
    @ElementCollection(fetch = FetchType.LAZY)
    private List<@Pattern(regexp = Validator.EMAIL_REGEX, message = "Incorrect email") String> contactEmails;
    @ElementCollection(fetch = FetchType.LAZY)
    private List<@Pattern(regexp = Validator.PHONE_NUMBER_REGEX, message = "Incorrect phone number") String> contactPhones;
    private String otherContactInfo;
    @OneToOne(fetch = FetchType.LAZY)
    private User account;
}
