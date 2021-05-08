package ua.nau.epf.repository;

import org.springframework.stereotype.Repository;
import ua.nau.epf.entity.teacher.Teacher;

import java.util.List;
import java.util.Optional;

@Repository
public interface TeacherRepository extends PersonBaseRepository<Teacher> {
    List<Teacher> findAll();

    Optional<Teacher> findByAccount_Id(Long id);
}
