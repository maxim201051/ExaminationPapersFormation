package ua.nau.epf.entity;

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
public class SemesterSubjectDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;
    @Column(nullable = false, columnDefinition = "int check ( total_hours > 0)")
    private int totalHours;
    @Column(nullable = false, columnDefinition = "int check ( lectures_hours > 0)")
    private int lecturesHours;
    @Column(nullable = false, columnDefinition = "int check ( practice_hours > 0)")
    private int practiceHours;
    @Column(nullable = false, columnDefinition = "int check ( lab_work_hours > 0)")
    private int labWorkHours;
    @Column(nullable = false, columnDefinition = "int check ( self_and_control_work_hours > 0)")
    private int selfAndControlWorkHours;
    @OneToOne(fetch = FetchType.LAZY)
    private Teacher responsibleTeacher;
    @Column(nullable = false)
    private boolean hasCourseWork;
    @ManyToOne(fetch = FetchType.LAZY)
    private Subject subject;
}
