package ua.nau.epf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.nau.epf.entity.SemesterSubjectDetails;

import java.util.List;
import java.util.Optional;

@Repository
public interface SemesterSubjectDetailsRepository extends JpaRepository<SemesterSubjectDetails, Long> {
    List<SemesterSubjectDetails> findAllByResponsibleTeacher_Id(Long id);
    Optional<SemesterSubjectDetails> findById(Long id);
    List<SemesterSubjectDetails> findAll();
}
