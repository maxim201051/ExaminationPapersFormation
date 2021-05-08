package ua.nau.epf.entity.student.recordbook;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.nau.epf.entity.SemesterSubjectDetails;
import ua.nau.epf.entity.teacher.Teacher;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class OtherUniversityDisciplineRecord extends RecordBookRecord {
    @ManyToOne(fetch = FetchType.LAZY)
    private SemesterSubjectDetails subject;
    @Column(nullable = false)
    private ControlForm controlForm;
    @Column(nullable = false)
    private String universityName;
    @Column(nullable = false)
    private String certificateDocumentName;
    @Column(nullable = false)
    private String certificateDocumentNumber;
    @Column(nullable = false) //todo column definition
    private Double creditNumber;
    @ManyToOne(fetch = FetchType.LAZY)
    private Teacher confirmingTeacher;
}
