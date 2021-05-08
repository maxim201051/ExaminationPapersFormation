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
public class DisciplineSemesterRecord extends RecordBookRecord {
    @Column(nullable = false)
    private ControlForm controlForm;
    @ManyToOne(fetch = FetchType.LAZY)
    private SemesterSubjectDetails relatedSubject;
    @ManyToOne(fetch = FetchType.LAZY)
    private Teacher signedTeacher;
    @Column(nullable = false, columnDefinition = "int check(passed_at_semester between 1 and 11)")
    private Integer passedAtSemester;
}
