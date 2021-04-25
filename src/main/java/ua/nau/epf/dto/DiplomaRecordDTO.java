package ua.nau.epf.dto;

import javafx.util.Pair;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class DiplomaRecordDTO extends RecordBookRecordDTO {
    private String diplomaTitle;
    private Pair<String, Long> supervisor;
    private boolean admittedToDefense;
    private String assignedQualification;
    private Map<String, Long> commissionMembers;
}
