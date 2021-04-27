package ua.nau.epf.repository;

import org.springframework.stereotype.Repository;
import ua.nau.epf.entity.student.recordbook.DisciplineSemesterRecord;

@Repository
public interface DisciplineSemesterRecordRepository extends RecordBookRecordBasedRepository<DisciplineSemesterRecord> {
}
