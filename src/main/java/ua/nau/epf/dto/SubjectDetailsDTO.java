package ua.nau.epf.dto;

import javafx.util.Pair;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubjectDetailsDTO {
    private int totalHours;
    private int lecturesHours;
    private int practiceHours;
    private int labWorkHours;
    private int selfAndControlWorkHours;
    private Pair<String, Long> responsibleTeacher;
    private boolean hasCourseWork;
    private Pair<String, Long> subject;
}
