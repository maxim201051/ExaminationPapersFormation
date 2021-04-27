package ua.nau.epf.mapper;

import ua.nau.epf.dto.CourseWorkRecordDTO;
import ua.nau.epf.entity.student.recordbook.CourseWorkRecord;

public class CourseWorkRecordMapper {
    private CourseWorkRecordMapper() {
    }

    public static CourseWorkRecordDTO mapEntityToDto(CourseWorkRecord entity) {
        CourseWorkRecordDTO dto = new CourseWorkRecordDTO();
        RecordBookRecordMapper.updateRecordDtoWithFieldsFromEntity(dto, entity);
        dto.setWorkTitle(entity.getWorkTitle());
        dto.setPassedAtSemester(entity.getPassedAtSemester());
        dto.setSubjectDetails(SubjectDetailsMapper.mapEntityToDto(entity.getRelatedSubject()));
        dto.setCommissionMembers(PersonMapper.mapPersonListToMap(entity.getCommissionMembers()));
        return dto;
    }

    public static CourseWorkRecord mapDtoToEntity(CourseWorkRecordDTO dto) {
        CourseWorkRecord entity = new CourseWorkRecord();
        RecordBookRecordMapper.updateRecordEntityWithFieldsFromDto(entity, dto);
        entity.setWorkTitle(dto.getWorkTitle());
        entity.setPassedAtSemester(dto.getPassedAtSemester());
        entity.setRelatedSubject(SubjectDetailsMapper.mapDtoToEntity(dto.getSubjectDetails()));
        entity.setCommissionMembers(TeacherMapper.mapTeacherMapToList(dto.getCommissionMembers()));
        return entity;
    }
}
