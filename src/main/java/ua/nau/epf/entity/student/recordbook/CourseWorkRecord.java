package ua.nau.epf.entity.student.recordbook;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.nau.epf.entity.SemesterSubjectDetails;
import ua.nau.epf.entity.teacher.Teacher;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CourseWorkRecord extends RecordBookRecord {
    @Column(nullable = false)
    private String workTitle;
    @Column(nullable = false, columnDefinition = "int check(passed_at_semester between 1 and 11)")
    private int passedAtSemester;
    @ManyToOne
    private SemesterSubjectDetails relatedSubject;
    @ManyToMany
    private List<Teacher> commissionMembers;
}
