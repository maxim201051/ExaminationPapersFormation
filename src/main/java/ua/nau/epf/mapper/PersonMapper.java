package ua.nau.epf.mapper;

import javafx.util.Pair;
import ua.nau.epf.dto.PersonInfoCardDTO;
import ua.nau.epf.entity.Person;
import ua.nau.epf.entity.user.User;

import java.util.*;
import java.util.stream.Collectors;

public class PersonMapper {
    private PersonMapper() {
    }

    public static void updatePersonDtoWithFieldsFromEntity(PersonInfoCardDTO dto, Person entity) {
        dto.setId(entity.getId());
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setPatronymic(entity.getPatronymic());
        dto.setContactEmails(new ArrayList<>(entity.getContactEmails()));
        dto.setContactPhones(new ArrayList<>(entity.getContactPhones()));
        dto.setOtherContactInfo(entity.getOtherContactInfo());
        dto.setAccountId(entity.getAccount().getId());
    }

    public static Person updatePersonEntityWithFieldsFromDto(Person entity, PersonInfoCardDTO dto) {
        entity.setId(dto.getId());
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setPatronymic(dto.getPatronymic());
        if (dto.getContactEmails() != null) {
            entity.setContactEmails(dto.getContactEmails());
        } else {
            entity.setContactEmails(Collections.emptyList());
        }
        if (dto.getContactPhones() != null) {
            entity.setContactPhones(dto.getContactPhones());
        } else {
            entity.setContactPhones(Collections.emptyList());
        }
        entity.setOtherContactInfo(dto.getOtherContactInfo());
        User account = new User();
        account.setId(dto.getAccountId());
        entity.setAccount(account);
        return entity;
    }

    public static Map<String, Long> mapPersonListToMap(List<? extends Person> personList) {
        return personList.stream().collect(Collectors.toMap(person -> new StringJoiner(" ")
                .add(person.getLastName())
                .add(person.getFirstName())
                .add(person.getPatronymic()).toString(), Person::getId));
    }

    public static Pair<String, Long> mapPersonToFullNameIdPair(Person person) {
        StringJoiner fullName = new StringJoiner(" ")
                .add(person.getLastName())
                .add(person.getFirstName())
                .add(person.getPatronymic());
        return new Pair<>(fullName.toString(), person.getId());
    }
}
