package ua.nau.epf.mapper;

import ua.nau.epf.dto.AdminHelpRequestDTO;
import ua.nau.epf.entity.AdminHelpRequest;
import ua.nau.epf.entity.Person;

public class AdminHelpRequestMapper {
    private AdminHelpRequestMapper() {
    }

    public static AdminHelpRequestDTO mapEntityToDto(AdminHelpRequest entity) {
        AdminHelpRequestDTO dto = new AdminHelpRequestDTO();
        dto.setId(entity.getId());
        dto.setSender(PersonMapper.mapPersonToFullNameIdPair(entity.getSender()));
        dto.setRequestText(entity.getRequestText());
        dto.setCreationDate(entity.getCreationDate());
        dto.setResolved(entity.getResolved());
        return dto;
    }

    public static AdminHelpRequest mapDtoToEntity(AdminHelpRequestDTO dto, Person sender) {
        AdminHelpRequest entity = new AdminHelpRequest();
        entity.setId(dto.getId());
        entity.setSender(sender);
        entity.setRequestText(dto.getRequestText());
        entity.setCreationDate(dto.getCreationDate());
        entity.setResolved(dto.getResolved());
        return entity;
    }
}
