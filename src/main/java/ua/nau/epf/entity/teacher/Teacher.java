package ua.nau.epf.entity.teacher;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.nau.epf.entity.Person;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Teacher extends Person {
    private Position position;
    private AcademicDegree academicDegree;
    private AcademicStatus academicStatus;
    private LocalDate hiringDate;
    private boolean dismissed;
    private LocalDate dismissalDate;
}
