package ua.nau.epf.mapper;

import ua.nau.epf.dto.CertificationRecordDTO;
import ua.nau.epf.entity.student.recordbook.CertificationRecord;

public class CertificationRecordMapper {
    private CertificationRecordMapper() {
    }

    public static CertificationRecordDTO mapEntityToDto(CertificationRecord entity) {
        CertificationRecordDTO dto = new CertificationRecordDTO();
        RecordBookRecordMapper.updateRecordDtoWithFieldsFromEntity(dto, entity);
        dto.setCertificationName(entity.getCertificationName());
        dto.setCommissionMembers(PersonMapper.mapPersonListToMap(entity.getCommissionMembers()));
        return dto;
    }

    public static CertificationRecord mapDtoToEntity(CertificationRecordDTO dto) {
        CertificationRecord entity = new CertificationRecord();
        RecordBookRecordMapper.updateRecordEntityWithFieldsFromDto(entity, dto);
        entity.setCertificationName(dto.getCertificationName());
        entity.setCommissionMembers(TeacherMapper.mapTeacherMapToList(dto.getCommissionMembers()));
        return entity;
    }
}
