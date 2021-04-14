package ua.nau.epf.entity.student.recordbook;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.nau.epf.entity.teacher.Teacher;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PracticeRecord extends RecordBookRecord {
    private String practiceName;
    private String organizationName;
    private int passedOnCourse;
    private String dateIntervalString;
    private String workKind;
    private int creditNumber;
    private Teacher signedTeacher;
}
