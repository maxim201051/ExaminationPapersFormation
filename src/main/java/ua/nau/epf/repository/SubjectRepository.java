package ua.nau.epf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.nau.epf.entity.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {
}
