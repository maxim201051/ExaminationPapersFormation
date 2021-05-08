package ua.nau.epf.repository;

import org.springframework.stereotype.Repository;
import ua.nau.epf.entity.Person;

@Repository
public interface PersonRepository extends PersonBaseRepository<Person> {
}
