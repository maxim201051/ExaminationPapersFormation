package ua.nau.epf.dto;

import lombok.Getter;
import lombok.Setter;
import ua.nau.epf.entity.student.recordbook.RecordBookRecord;

import java.util.Map;

@Getter
@Setter
public class ExaminationPaperDTO {
    private Long groupId;
    private String groupName;
    private String subjectName;
    private Map<String, RecordBookRecord> row;
}
