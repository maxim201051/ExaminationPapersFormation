package ua.nau.epf.mapper;

import ua.nau.epf.dto.AdminHelpRequestDTO;
import ua.nau.epf.entity.AdminHelpRequest;

public class AdminHelpRequestMapper {
    private AdminHelpRequestMapper() {
    }

    public static AdminHelpRequestDTO mapEntityToDto(AdminHelpRequest entity) {
        AdminHelpRequestDTO dto = new AdminHelpRequestDTO();
        dto.setId(entity.getId());
        dto.setSender(PersonMapper.mapPersonToFullNameIdPair(entity.getSender()));
        dto.setRequestText(entity.getRequestText());
        dto.setCreationDate(entity.getCreationDate());
        dto.setResolved(entity.isResolved());
        return dto;
    }

    public static AdminHelpRequest mapDtoToEntity(AdminHelpRequestDTO dto) {
        AdminHelpRequest entity = new AdminHelpRequest();
        entity.setId(dto.getId());
        entity.setSender(PersonMapper.mapFullNameIdPairToPerson(dto.getSender()));
        entity.setRequestText(dto.getRequestText());
        entity.setCreationDate(dto.getCreationDate());
        entity.setResolved(dto.isResolved());
        return entity;
    }
}
