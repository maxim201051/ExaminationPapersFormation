package ua.nau.epf.dto;

import lombok.Getter;
import lombok.Setter;
import ua.nau.epf.util.Validator;

import javax.validation.constraints.Pattern;
import java.util.List;

@Getter
@Setter
public class PersonInfoCardDTO {
    private Long id;
    @Pattern(regexp = Validator.NAME_REGEX, message = "First name do not match regex " + Validator.NAME_REGEX)
    private String firstName;
    @Pattern(regexp = Validator.NAME_REGEX, message = "Last name do not match regex " + Validator.NAME_REGEX)
    private String lastName;
    @Pattern(regexp = Validator.NAME_REGEX, message = "Patronymic do not match regex " + Validator.NAME_REGEX)
    private String patronymic;
    private List<@Pattern(regexp = Validator.EMAIL_REGEX, message = "Incorrect email") String> contactEmails;
    private List<@Pattern(regexp = Validator.PHONE_NUMBER_REGEX, message = "Incorrect phone number") String> contactPhones;
    private String otherContactInfo;
    private Long accountId;
}
