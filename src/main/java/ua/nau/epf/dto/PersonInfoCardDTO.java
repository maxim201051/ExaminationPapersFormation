package ua.nau.epf.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PersonInfoCardDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String patronymic;
    private List<String> contactEmails;
    private List<String> contactPhones;
    private String otherContactInfo;
}
