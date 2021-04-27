package ua.nau.epf.repository;

import org.springframework.stereotype.Repository;
import ua.nau.epf.entity.student.recordbook.DiplomaRecord;

@Repository
public interface DiplomaRecordRepository extends RecordBookRecordBasedRepository<DiplomaRecord> {
}
