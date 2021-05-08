package ua.nau.epf.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class StudentTailDTO {
    private String subject;
    private String studentFullName;
    private String group;
    private List<RecordBookRecordDTO> record;
}
