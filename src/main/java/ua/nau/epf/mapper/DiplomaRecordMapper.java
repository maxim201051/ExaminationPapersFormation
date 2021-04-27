package ua.nau.epf.mapper;

import ua.nau.epf.dto.DiplomaRecordDTO;
import ua.nau.epf.entity.student.EducationalDegree;
import ua.nau.epf.entity.student.recordbook.DiplomaRecord;

public class DiplomaRecordMapper {
    private DiplomaRecordMapper() {
    }

    public static DiplomaRecordDTO mapEntityToDto(DiplomaRecord entity) {
        DiplomaRecordDTO dto = new DiplomaRecordDTO();
        RecordBookRecordMapper.updateRecordDtoWithFieldsFromEntity(dto, entity);
        dto.setDiplomaTitle(entity.getDiplomaTitle());
        dto.setSupervisor(PersonMapper.mapPersonToFullNameIdPair(entity.getSupervisor()));
        dto.setAdmittedToDefense(entity.isAdmittedToDefense());
        dto.setAssignedQualification(entity.getAssignedQualification().name());
        dto.setCommissionMembers(PersonMapper.mapPersonListToMap(entity.getCommissionMembers()));
        return dto;
    }

    public static DiplomaRecord mapDtoToEntity(DiplomaRecordDTO dto) {
        DiplomaRecord entity = new DiplomaRecord();
        RecordBookRecordMapper.updateRecordEntityWithFieldsFromDto(entity, dto);
        entity.setDiplomaTitle(dto.getDiplomaTitle());
        entity.setSupervisor(TeacherMapper.mapFullNameIdPairToTeacher(dto.getSupervisor()));
        entity.setAdmittedToDefense(dto.isAdmittedToDefense());
        entity.setAssignedQualification(EducationalDegree.valueOf(dto.getAssignedQualification()));
        entity.setCommissionMembers(TeacherMapper.mapTeacherMapToList(dto.getCommissionMembers()));
        return entity;
    }
}
