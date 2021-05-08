package ua.nau.epf.dto;

import javafx.util.Pair;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OtherUniversityDisciplineRecordDTO extends RecordBookRecordDTO {
    private SubjectDetailsDTO subject;
    private String controlForm;
    private String universityName;
    private String certificateDocumentName;
    private String certificateDocumentNumber;
    private Double creditNumber;
    private Pair<String, Long> confirmingTeacher;
}
