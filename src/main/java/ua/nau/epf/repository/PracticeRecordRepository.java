package ua.nau.epf.repository;

import org.springframework.stereotype.Repository;
import ua.nau.epf.entity.student.recordbook.PracticeRecord;

@Repository
public interface PracticeRecordRepository extends RecordBookRecordBasedRepository<PracticeRecord> {
}
