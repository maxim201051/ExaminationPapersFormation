package ua.nau.epf.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class CourseWorkRecordDTO extends RecordBookRecordDTO {
    private String workTitle;
    private int passedAtSemester;
    private SubjectDetailsDTO subjectDetails;
    private Map<String, Long> commissionMembers;
}
