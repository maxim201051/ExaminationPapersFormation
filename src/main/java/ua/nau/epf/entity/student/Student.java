package ua.nau.epf.entity.student;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.nau.epf.entity.Person;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Student extends Person {
    private String studentCode;
    private Group group;
    private RecordBook recordBook;
}
