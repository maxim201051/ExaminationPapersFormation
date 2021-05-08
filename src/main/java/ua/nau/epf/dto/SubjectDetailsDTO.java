package ua.nau.epf.dto;

import javafx.util.Pair;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubjectDetailsDTO {
    private Long id;
    private Integer totalHours;
    private Integer lecturesHours;
    private Integer practiceHours;
    private Integer labWorkHours;
    private Integer selfAndControlWorkHours;
    private Pair<String, Long> responsibleTeacher;
    private Boolean hasCourseWork;
    private Pair<String, Long> subject;
    private String controlForm;
    private Double creditNumber;
}
