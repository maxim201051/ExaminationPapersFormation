package ua.nau.epf.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class GroupDTO {
    private Long id;
    private String groupNumber;
    private GroupStudentStudyInfoDTO studyInfo;
    private Map<String, Long> students;
}
