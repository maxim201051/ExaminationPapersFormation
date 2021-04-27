package ua.nau.epf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.nau.epf.entity.AdminHelpRequest;

@Repository
public interface AdminHelpRequestRepository extends JpaRepository<AdminHelpRequest, Long> {
}
