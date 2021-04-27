package ua.nau.epf.repository;

import org.springframework.stereotype.Repository;
import ua.nau.epf.entity.student.Student;

@Repository
public interface StudentRepository extends PersonBaseRepository<Student> {

}
