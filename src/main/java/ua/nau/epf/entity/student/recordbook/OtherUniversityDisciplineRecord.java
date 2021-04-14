package ua.nau.epf.entity.student.recordbook;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.nau.epf.entity.Subject;
import ua.nau.epf.entity.teacher.Teacher;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OtherUniversityDisciplineRecord extends RecordBookRecord {
    private Subject subject;
    private ControlForm controlForm;
    private String universityName;
    private String certificateDocumentName;
    private String certificateDocumentNumber;
    private Teacher confirmingTeacher;
}
