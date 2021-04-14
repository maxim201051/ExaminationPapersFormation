package ua.nau.epf.entity.student;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.nau.epf.entity.student.recordbook.RecordBookRecord;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RecordBook {
    private Long id;
    private List<RecordBookRecord> recordBookRecords;
}
