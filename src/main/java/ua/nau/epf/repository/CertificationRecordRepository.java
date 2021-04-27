package ua.nau.epf.repository;

import org.springframework.stereotype.Repository;
import ua.nau.epf.entity.student.recordbook.CertificationRecord;

@Repository
public interface CertificationRecordRepository extends RecordBookRecordBasedRepository<CertificationRecord> {
}
