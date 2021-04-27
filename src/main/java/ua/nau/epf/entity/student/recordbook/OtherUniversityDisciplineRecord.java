package ua.nau.epf.entity.student.recordbook;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.nau.epf.entity.SemesterSubjectDetails;
import ua.nau.epf.entity.teacher.Teacher;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class OtherUniversityDisciplineRecord extends RecordBookRecord {
    @ManyToOne
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
    private double creditNumber;
    @ManyToOne
    private Teacher confirmingTeacher;
}
