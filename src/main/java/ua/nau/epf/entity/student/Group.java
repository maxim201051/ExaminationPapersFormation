package ua.nau.epf.entity.student;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.nau.epf.entity.Person;
import ua.nau.epf.entity.Subject;

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
    private int course;
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
    private Person curator;
    @Column(nullable = false)
    private LocalDate startOfStudy;
    @Column(nullable = false)
    private boolean graduated;
    private LocalDate graduationDate;//todo decide to leave list of students in group or link to group in student
    @OneToMany(fetch = FetchType.LAZY)
    private List<Student> students;
    @OneToMany(fetch = FetchType.LAZY)
    private List<Subject> studiedDisciplines;
}
