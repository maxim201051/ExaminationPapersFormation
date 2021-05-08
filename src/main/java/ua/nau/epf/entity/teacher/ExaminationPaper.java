package ua.nau.epf.entity.teacher;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.nau.epf.entity.SemesterSubjectDetails;
import ua.nau.epf.entity.student.Group;
import ua.nau.epf.entity.student.recordbook.ControlForm;
import ua.nau.epf.entity.student.recordbook.DisciplineSemesterRecord;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"educational_year_string", "passed_at_semester",
        "control_form", "responsible_teacher_id", "group_id", "related_subject_id"})})
public class ExaminationPaper {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;
    @Column(name = "educational_year_string", nullable = false)
    private String educationalYearString;
    @Column(name = "passed_at_semester", nullable = false)
    private Integer passedAtSemester;
    @Column(name = "control_form", nullable = false)
    private ControlForm controlForm;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "responsible_teacher_id", nullable = false)
    private Teacher responsibleTeacher;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id", nullable = false)
    private Group group;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "related_subject_id", nullable = false)
    private SemesterSubjectDetails relatedSubject;
    @OneToMany(fetch = FetchType.LAZY)
    private List<DisciplineSemesterRecord> relatedRecordBookRecords;
    private LocalDate controlDate;
}
