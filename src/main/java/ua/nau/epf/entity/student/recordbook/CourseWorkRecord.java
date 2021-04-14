package ua.nau.epf.entity.student.recordbook;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.nau.epf.entity.Subject;
import ua.nau.epf.entity.teacher.Teacher;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CourseWorkRecord extends RecordBookRecord {
    private String workTitle;
    private int passedAtSemester;
    private Subject relatedSubject;
    private List<Teacher> commissionMembers;
}
