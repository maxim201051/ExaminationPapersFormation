package ua.nau.epf.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.nau.epf.entity.user.User;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private Long id;
    private String firstName;
    private String lastName;
    private String patronymic;
    private List<String> contactEmails;
    private List<String> contactPhones;
    private String otherContactInfo;
    private User account;
}
