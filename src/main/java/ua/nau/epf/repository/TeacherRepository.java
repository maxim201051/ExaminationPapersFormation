package ua.nau.epf.repository;

import org.springframework.stereotype.Repository;
import ua.nau.epf.entity.teacher.Teacher;

@Repository
public interface TeacherRepository extends PersonBaseRepository<Teacher> {

}
