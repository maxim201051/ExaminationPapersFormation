package ua.nau.epf.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.nau.epf.dto.AdminHelpRequestDTO;
import ua.nau.epf.exception.QueryReturnedNoResultsException;
import ua.nau.epf.mapper.AdminHelpRequestMapper;
import ua.nau.epf.repository.AdminHelpRequestRepository;
import ua.nau.epf.repository.PersonRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminHelpRequestService {
    private final AdminHelpRequestRepository adminHelpRequestRepository;
    private final PersonRepository personRepository;

    @Autowired
    public AdminHelpRequestService(AdminHelpRequestRepository adminHelpRequestRepository, PersonRepository personRepository) {
        this.adminHelpRequestRepository = adminHelpRequestRepository;
        this.personRepository = personRepository;
    }

    @Transactional
    public AdminHelpRequestDTO saveAdminHelpRequest(AdminHelpRequestDTO adminHelpRequest) throws QueryReturnedNoResultsException {
        return AdminHelpRequestMapper.mapEntityToDto(adminHelpRequestRepository
                .save(AdminHelpRequestMapper.mapDtoToEntity(adminHelpRequest,
                        personRepository.findById(adminHelpRequest.getSender().getValue())
                                .orElseThrow(QueryReturnedNoResultsException::new))));
    }

    @Transactional
    public AdminHelpRequestDTO findAdminHelpRequestById(Long id) throws QueryReturnedNoResultsException {
        return AdminHelpRequestMapper.mapEntityToDto(
                adminHelpRequestRepository.findById(id).orElseThrow(QueryReturnedNoResultsException::new));
    }

    @Transactional
    public List<AdminHelpRequestDTO> findAllAdminHelpRequests() {
        return adminHelpRequestRepository.findAll().stream()
                .map(AdminHelpRequestMapper::mapEntityToDto).collect(Collectors.toList());
    }
}
