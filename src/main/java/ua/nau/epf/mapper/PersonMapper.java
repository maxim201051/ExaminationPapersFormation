package ua.nau.epf.mapper;

import javafx.util.Pair;
import ua.nau.epf.dto.PersonInfoCardDTO;
import ua.nau.epf.entity.Person;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

public class PersonMapper {
    private PersonMapper() {
    }

    public static void updatePersonDtoWithFieldsFromEntity(PersonInfoCardDTO dto, Person entity) {
        dto.setId(entity.getId());
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setPatronymic(entity.getPatronymic());
        dto.setContactEmails(entity.getContactEmails());
        dto.setContactPhones(entity.getContactPhones());
        dto.setOtherContactInfo(entity.getOtherContactInfo());
    }

    public static Person updatePersonEntityWithFieldsFromDto(Person entity, PersonInfoCardDTO dto) {
        entity.setId(dto.getId());
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setPatronymic(dto.getPatronymic());
        entity.setContactEmails(dto.getContactEmails());
        entity.setContactPhones(dto.getContactPhones());
        entity.setOtherContactInfo(dto.getOtherContactInfo());
        return entity;
    }

    public static Map<String, Long> mapPersonListToMap(List<? extends Person> personList) {
        Map<String, Long> personFullNameIdMap = new HashMap<>();
        for (Person person : personList) {
            StringJoiner fullName = new StringJoiner(" ")
                    .add(person.getLastName())
                    .add(person.getFirstName())
                    .add(person.getPatronymic());
            personFullNameIdMap.put(fullName.toString(), person.getId());
        }
        return personFullNameIdMap;
    }

    public static Pair<String, Long> mapPersonToFullNameIdPair(Person person) {
        StringJoiner fullName = new StringJoiner(" ")
                .add(person.getLastName())
                .add(person.getFirstName())
                .add(person.getPatronymic());
        return new Pair<>(fullName.toString(), person.getId());
    }
}
