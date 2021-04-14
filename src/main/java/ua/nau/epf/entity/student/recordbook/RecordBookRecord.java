package ua.nau.epf.entity.student.recordbook;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RecordBookRecord {
    private Long id;
    private NationalScale nationalScaleMark;
    private int numberOfPoints;
    private ECTSScale ectsScaleMark;
    private LocalDate recordDate;
}
