package ua.nau.epf.dto;

import javafx.util.Pair;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentInfoCardDTO extends PersonInfoCardDTO {
    private Pair<String, Long> group;
    private String studentCode;
    private GroupStudentStudyInfoDTO studyInfo;
}
