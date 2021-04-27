package ua.nau.epf.mapper;

import ua.nau.epf.dto.DisciplineSemesterRecordDTO;
import ua.nau.epf.entity.student.recordbook.ControlForm;
import ua.nau.epf.entity.student.recordbook.DisciplineSemesterRecord;

public class DisciplineSemesterRecordMapper {
    public DisciplineSemesterRecordDTO mapEntityToDto(DisciplineSemesterRecord entity) {
        DisciplineSemesterRecordDTO dto = new DisciplineSemesterRecordDTO();
        RecordBookRecordMapper.updateRecordDtoWithFieldsFromEntity(dto, entity);
        dto.setControlForm(entity.getControlForm().name());
        dto.setSubject(SubjectDetailsMapper.mapEntityToDto(entity.getSubject()));
        dto.setCreditNumber(entity.getCreditNumber());
        dto.setSignedTeacher(PersonMapper.mapPersonToFullNameIdPair(entity.getSignedTeacher()));
        dto.setPassedAtSemester(entity.getPassedAtSemester());
        return dto;
    }

    public DisciplineSemesterRecord mapDtoToEntity(DisciplineSemesterRecordDTO dto) {
        DisciplineSemesterRecord entity = new DisciplineSemesterRecord();
        RecordBookRecordMapper.updateRecordEntityWithFieldsFromDto(entity, dto);
        entity.setControlForm(ControlForm.valueOf(dto.getControlForm()));
        entity.setSubject(SubjectDetailsMapper.mapDtoToEntity(dto.getSubject()));
        entity.setCreditNumber(dto.getCreditNumber());
        entity.setSignedTeacher(TeacherMapper.mapFullNameIdPairToTeacher(dto.getSignedTeacher()));
        entity.setPassedAtSemester(dto.getPassedAtSemester());
        return entity;
    }
}
