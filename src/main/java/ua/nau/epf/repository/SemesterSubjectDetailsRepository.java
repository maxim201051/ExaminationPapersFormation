package ua.nau.epf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.nau.epf.entity.SemesterSubjectDetails;

@Repository
public interface SemesterSubjectDetailsRepository extends JpaRepository<SemesterSubjectDetails, Long> {
}
