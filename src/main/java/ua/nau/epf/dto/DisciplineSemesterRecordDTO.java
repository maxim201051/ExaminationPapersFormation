package ua.nau.epf.dto;

import javafx.util.Pair;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DisciplineSemesterRecordDTO extends RecordBookRecordDTO {
    private String controlForm;
    private SubjectDetailsDTO subject;
    private double creditNumber;
    private Pair<String, Long> signedTeacher;
    private int passedAtSemester;
}
