package ua.nau.epf.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class GroupDTO {
    private Long id;
    private GroupStudentStudyInfoDTO studyInfo;
    //key - full name, value - id
    private Map<String, Long> students;
}
