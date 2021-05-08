package ua.nau.epf.dto;

import javafx.util.Pair;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class ExaminationPaperDTO {
    private Long id;
    private String speciality;
    private String specialization;
    private String educationalYear;
    private Integer course;
    private Integer semester;
    private String controlForm;
    private Pair<String, Long> responsibleTeacher;
    private Pair<String, Long> group;
    private Pair<String, Long> subject;
    private List<StudentDisciplineRecordDTO> rows;
    private LocalDate controlDate;
}
