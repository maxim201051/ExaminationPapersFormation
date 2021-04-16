package ua.nau.epf.entity.student.recordbook;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.nau.epf.entity.Person;
import ua.nau.epf.entity.SemesterSubjectDetails;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class DisciplineSemesterRecord extends RecordBookRecord {
    @Column(nullable = false)
    private ControlForm controlForm;
    @ManyToOne
    private SemesterSubjectDetails subject;
    @Column(nullable = false) //todo column definition
    private double creditNumber;
    @ManyToOne
    private Person signedTeacher;
    @Column(nullable = false, columnDefinition = "int check(passed_at_semester between 1 and 11)")
    private int passedAtSemester;
}
