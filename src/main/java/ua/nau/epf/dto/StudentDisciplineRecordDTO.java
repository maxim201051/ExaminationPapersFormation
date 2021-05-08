package ua.nau.epf.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentDisciplineRecordDTO {
    private StudentInfoCardDTO student;
    private DisciplineSemesterRecordDTO record;
}
