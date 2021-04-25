package ua.nau.epf.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public abstract class RecordBookRecordDTO {
    private String nationalScaleMark;
    private int numberOfPoints;
    private String ectsScaleMark;
    private LocalDate recordDate;
}
