package ua.nau.epf.mapper;

import ua.nau.epf.dto.CertificationRecordDTO;
import ua.nau.epf.entity.student.recordbook.CertificationRecord;
import ua.nau.epf.entity.teacher.Teacher;

import java.util.List;

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

    public static CertificationRecord mapDtoToEntity(CertificationRecordDTO dto, List<Teacher> commissionMembers) {
        CertificationRecord entity = new CertificationRecord();
        RecordBookRecordMapper.updateRecordEntityWithFieldsFromDto(entity, dto);
        entity.setCertificationName(dto.getCertificationName());
        entity.setCommissionMembers(commissionMembers);
        return entity;
    }
}
