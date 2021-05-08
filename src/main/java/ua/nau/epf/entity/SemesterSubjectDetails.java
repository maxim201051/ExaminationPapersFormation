package ua.nau.epf.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.nau.epf.entity.student.recordbook.ControlForm;
import ua.nau.epf.entity.teacher.Teacher;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"total_hours", "lectures_hours", "practice_hours",
        "lab_work_hours", "self_and_control_work_hours", "responsible_teacher_id", "has_course_work", "subject_id",
"control_form", "credit_number"})})
//todo column definition
public class SemesterSubjectDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;
    @Column(name = "total_hours",nullable = false, columnDefinition = "int check ( total_hours > 0)")
    private Integer totalHours;
    @Column(name = "lectures_hours", nullable = false, columnDefinition = "int check ( lectures_hours > 0)")
    private Integer lecturesHours;
    @Column(name = "practice_hours", nullable = false, columnDefinition = "int check ( practice_hours > 0)")
    private Integer practiceHours;
    @Column(name = "lab_work_hours", nullable = false, columnDefinition = "int check ( lab_work_hours > 0)")
    private Integer labWorkHours;
    @Column(name = "self_and_control_work_hours", nullable = false, columnDefinition = "int check ( self_and_control_work_hours > 0)")
    private Integer selfAndControlWorkHours;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "responsible_teacher_id", nullable = false)
    private Teacher responsibleTeacher;
    @Column(name = "has_course_work", nullable = false)
    private Boolean hasCourseWork;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subject_id", nullable = false)
    private Subject subject;
    @Column(name = "control_form", nullable = false)
    private ControlForm controlForm;
    @Column(name = "credit_number", nullable = false)
    private Double creditNumber;
}
