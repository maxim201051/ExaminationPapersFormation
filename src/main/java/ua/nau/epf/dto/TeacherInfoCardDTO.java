package ua.nau.epf.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class TeacherInfoCardDTO extends PersonInfoCardDTO {
    private String position;
    private String academicDegree;
    private String academicStatus;
    private LocalDate hiringDate;
    private boolean dismissed;
    private LocalDate dismissalDate;
}
