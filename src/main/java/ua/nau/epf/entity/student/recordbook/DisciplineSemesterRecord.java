package ua.nau.epf.entity.student.recordbook;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.nau.epf.entity.Subject;
import ua.nau.epf.entity.teacher.Teacher;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DisciplineSemesterRecord extends RecordBookRecord {
    private ControlForm controlForm;
    private Subject subject;
    private Teacher signedTeacher;
    private int passedAtSemester;
}
