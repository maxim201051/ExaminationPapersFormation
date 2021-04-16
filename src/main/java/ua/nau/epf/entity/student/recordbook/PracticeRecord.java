package ua.nau.epf.entity.student.recordbook;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.nau.epf.entity.Person;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PracticeRecord extends RecordBookRecord {
    @Column(nullable = false)
    private String practiceName;
    @Column(nullable = false)
    private String organizationName;
    @Column(nullable = false, columnDefinition = "int check(passed_on_course between 1 and 6)")
    private int passedOnCourse;
    @Column(nullable = false)
    private String dateIntervalString;
    @Column(nullable = false)
    private String workKind;
    @Column(nullable = false) //todo column definition
    private double creditNumber;
    @ManyToOne
    private Person signedTeacher;
}
