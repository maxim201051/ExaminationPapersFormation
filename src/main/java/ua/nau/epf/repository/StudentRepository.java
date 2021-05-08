package ua.nau.epf.repository;

import org.springframework.stereotype.Repository;
import ua.nau.epf.entity.student.Student;
import ua.nau.epf.entity.student.recordbook.RecordBookRecord;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends PersonBaseRepository<Student> {
    Optional<Student> findById(Long id);

    List<Student> findAll();

    List<Student> findAllByGroup_Id(Long id);

    Optional<Student> findByAccount_Id(Long id);

    Optional<Student> findByRecordBookContains(RecordBookRecord record);
}
