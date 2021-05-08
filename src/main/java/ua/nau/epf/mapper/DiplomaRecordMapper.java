package ua.nau.epf.mapper;

import ua.nau.epf.dto.DiplomaRecordDTO;
import ua.nau.epf.entity.student.EducationalDegree;
import ua.nau.epf.entity.student.recordbook.DiplomaRecord;
import ua.nau.epf.entity.teacher.Teacher;

import java.util.List;

public class DiplomaRecordMapper {
    private DiplomaRecordMapper() {
    }

    public static DiplomaRecordDTO mapEntityToDto(DiplomaRecord entity) {
        DiplomaRecordDTO dto = new DiplomaRecordDTO();
        RecordBookRecordMapper.updateRecordDtoWithFieldsFromEntity(dto, entity);
        dto.setDiplomaTitle(entity.getDiplomaTitle());
        dto.setSupervisor(PersonMapper.mapPersonToFullNameIdPair(entity.getSupervisor()));
        dto.setAdmittedToDefense(entity.getAdmittedToDefense());
        dto.setAssignedQualification(entity.getAssignedQualification().name());
        dto.setCommissionMembers(PersonMapper.mapPersonListToMap(entity.getCommissionMembers()));
        return dto;
    }

    public static DiplomaRecord mapDtoToEntity(DiplomaRecordDTO dto, Teacher supervisor, List<Teacher> commissionMembers) {
        DiplomaRecord entity = new DiplomaRecord();
        RecordBookRecordMapper.updateRecordEntityWithFieldsFromDto(entity, dto);
        entity.setDiplomaTitle(dto.getDiplomaTitle());
        entity.setSupervisor(supervisor);
        entity.setAdmittedToDefense(dto.getAdmittedToDefense());
        entity.setAssignedQualification(EducationalDegree.valueOf(dto.getAssignedQualification()));
        entity.setCommissionMembers(commissionMembers);
        return entity;
    }
}
