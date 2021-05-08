package ua.nau.epf.dto;

import javafx.util.Pair;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class GroupStudentStudyInfoDTO {
    private Integer course;
    private String educationalDegree;
    private String knowledgeBranch;
    private String speciality;
    private String specialization;
    private String educationForm;
    private LocalDate startOfStudy;
    private Boolean graduated;
    private LocalDate endOfStudy;
    private Pair<String, Long> curator;
}
