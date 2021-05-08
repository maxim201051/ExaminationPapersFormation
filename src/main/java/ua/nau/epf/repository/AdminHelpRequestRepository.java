package ua.nau.epf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.nau.epf.entity.AdminHelpRequest;

import java.util.List;
import java.util.Optional;

@Repository
public interface AdminHelpRequestRepository extends JpaRepository<AdminHelpRequest, Long> {
    Optional<AdminHelpRequest> findById(Long id);

    List<AdminHelpRequest> findAll();
}
