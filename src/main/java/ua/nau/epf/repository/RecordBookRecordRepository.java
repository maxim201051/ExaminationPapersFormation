package ua.nau.epf.repository;

import org.springframework.stereotype.Repository;
import ua.nau.epf.entity.student.recordbook.RecordBookRecord;

@Repository
public interface RecordBookRecordRepository extends RecordBookRecordBasedRepository<RecordBookRecord> {
}
