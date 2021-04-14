package ua.nau.epf.entity.student;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.nau.epf.entity.Subject;
import ua.nau.epf.entity.teacher.Teacher;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Group {
    private Long id;
    private String groupNo;
    private int course;
    private EducationalDegree educationalDegree;
    private String knowledgeBranch;
    private String speciality;
    private String specialization;
    private EducationForm educationForm;
    private Teacher curator;
    private LocalDate startOfStudy;
    private boolean graduated;
    private LocalDate graduationDate;
    private List<Student> students;
    private List<Subject> studiedDisciplines;
}
