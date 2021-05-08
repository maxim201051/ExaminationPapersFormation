package ua.nau.epf.dto;

import javafx.util.Pair;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PracticeRecordDTO extends RecordBookRecordDTO {
    private String practiceName;
    private String organizationName;
    private Integer passedOnCourse;
    private String dateIntervalString;
    private String workKind;
    private Double creditNumber;
    private Pair<String, Long> signedTeacher;
}
