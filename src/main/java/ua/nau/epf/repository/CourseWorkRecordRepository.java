package ua.nau.epf.repository;

import org.springframework.stereotype.Repository;
import ua.nau.epf.entity.student.recordbook.CourseWorkRecord;

@Repository
public interface CourseWorkRecordRepository extends RecordBookRecordBasedRepository<CourseWorkRecord> {
}
