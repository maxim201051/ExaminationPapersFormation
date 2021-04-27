package ua.nau.epf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.nau.epf.entity.student.Group;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {
}
