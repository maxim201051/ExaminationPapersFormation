package ua.nau.epf.entity.student;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.nau.epf.entity.SemesterSubjectDetails;
import ua.nau.epf.entity.teacher.Teacher;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;
    @Column(nullable = false, unique = true)
    private String groupNumber;
    @Column(nullable = false, columnDefinition = "int check(course between 1 and 6)")
    private Integer course;
    @Column(nullable = false)
    private EducationalDegree educationalDegree;
    @Column(nullable = false)
    private String knowledgeBranch;
    @Column(nullable = false)
    private String speciality;
    @Column(nullable = false)
    private String specialization;
    @Column(nullable = false)
    private EducationForm educationForm;
    @ManyToOne(fetch = FetchType.LAZY)
    private Teacher curator;
    @Column(nullable = false)
    private LocalDate startOfStudy;
    @Column(nullable = false)
    private Boolean graduated;
    private LocalDate graduationDate;
    @ManyToMany(fetch = FetchType.LAZY)
    private List<SemesterSubjectDetails> studiedDisciplines;
}
