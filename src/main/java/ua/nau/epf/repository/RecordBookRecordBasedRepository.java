package ua.nau.epf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import ua.nau.epf.entity.student.recordbook.RecordBookRecord;

@NoRepositoryBean
public interface RecordBookRecordBasedRepository<T extends RecordBookRecord> extends JpaRepository<T, Long> {
}
