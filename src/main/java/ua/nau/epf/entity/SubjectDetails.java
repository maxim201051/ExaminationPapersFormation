package ua.nau.epf.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.nau.epf.entity.teacher.Teacher;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SubjectDetails {
    private Long id;
    private int totalHours;
    private int lecturesHours;
    private int practiceHours;
    private int labWorkHours;
    private int selfAndControlWorkHours;
    private Teacher responsibleTeacher;
    private boolean completedDiscipline;
    private LocalDate completionDate;
}
