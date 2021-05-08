package ua.nau.epf.mapper;

import ua.nau.epf.dto.PracticeRecordDTO;
import ua.nau.epf.entity.student.recordbook.PracticeRecord;
import ua.nau.epf.entity.teacher.Teacher;

public class PracticeMapper {
    public static PracticeRecordDTO mapEntityToDto(PracticeRecord entity) {
        PracticeRecordDTO dto = new PracticeRecordDTO();
        RecordBookRecordMapper.updateRecordDtoWithFieldsFromEntity(dto, entity);
        dto.setPracticeName(entity.getPracticeName());
        dto.setOrganizationName(entity.getOrganizationName());
        dto.setPassedOnCourse(entity.getPassedOnCourse());
        dto.setDateIntervalString(entity.getDateIntervalString());
        dto.setWorkKind(entity.getWorkKind());
        dto.setCreditNumber(entity.getCreditNumber());
        dto.setSignedTeacher(PersonMapper.mapPersonToFullNameIdPair(entity.getSignedTeacher()));
        return dto;
    }

    public static PracticeRecord mapDtoToEntity(PracticeRecordDTO dto, Teacher signedTeacher) {
        PracticeRecord entity = new PracticeRecord();
        RecordBookRecordMapper.updateRecordEntityWithFieldsFromDto(entity, dto);
        entity.setPracticeName(dto.getPracticeName());
        entity.setOrganizationName(dto.getOrganizationName());
        entity.setPassedOnCourse(dto.getPassedOnCourse());
        entity.setDateIntervalString(dto.getDateIntervalString());
        entity.setWorkKind(dto.getWorkKind());
        entity.setCreditNumber(dto.getCreditNumber());
        entity.setSignedTeacher(signedTeacher);
        return entity;
    }
}
