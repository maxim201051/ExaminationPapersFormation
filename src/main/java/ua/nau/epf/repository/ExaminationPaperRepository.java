package ua.nau.epf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.nau.epf.entity.student.recordbook.ControlForm;
import ua.nau.epf.entity.teacher.ExaminationPaper;

import java.util.Optional;

@Repository
public interface ExaminationPaperRepository extends JpaRepository<ExaminationPaper, Long> {
    Optional<ExaminationPaper> findByGroup_IdAndRelatedSubject_IdAndPassedAtSemesterAndControlForm(
            Long groupId, Long subjectId, Integer passedAtSemester, ControlForm controlForm);
}
