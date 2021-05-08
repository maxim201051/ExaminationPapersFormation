package ua.nau.epf.entity.student.recordbook;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.nau.epf.entity.teacher.Teacher;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class PracticeRecord extends RecordBookRecord {
    @Column(nullable = false)
    private String practiceName;
    @Column(nullable = false)
    private String organizationName;
    @Column(nullable = false, columnDefinition = "int check(passed_on_course between 1 and 6)")
    private Integer passedOnCourse;
    @Column(nullable = false)
    private String dateIntervalString;
    @Column(nullable = false)
    private String workKind;
    @Column(nullable = false) //todo column definition
    private Double creditNumber;
    @ManyToOne(fetch = FetchType.LAZY)
    private Teacher signedTeacher;
}
