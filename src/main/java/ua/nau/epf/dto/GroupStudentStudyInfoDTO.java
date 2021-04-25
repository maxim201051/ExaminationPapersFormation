package ua.nau.epf.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class GroupStudentStudyInfoDTO {
    private String groupNumber;
    private int course;
    private String educationalDegree;
    private String knowledgeBranch;
    private String speciality;
    private String specialization;
    private String educationForm;
    private LocalDate startOfStudy;
    private boolean graduated;
    private LocalDate endOfStudy;
}
