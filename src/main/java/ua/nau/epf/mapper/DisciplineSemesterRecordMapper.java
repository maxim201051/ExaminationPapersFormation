package ua.nau.epf.mapper;

import ua.nau.epf.dto.DisciplineSemesterRecordDTO;
import ua.nau.epf.entity.Subject;
import ua.nau.epf.entity.student.recordbook.ControlForm;
import ua.nau.epf.entity.student.recordbook.DisciplineSemesterRecord;
import ua.nau.epf.entity.teacher.Teacher;

public class DisciplineSemesterRecordMapper {
    public static DisciplineSemesterRecordDTO mapEntityToDto(DisciplineSemesterRecord entity) {
        DisciplineSemesterRecordDTO dto = new DisciplineSemesterRecordDTO();
        RecordBookRecordMapper.updateRecordDtoWithFieldsFromEntity(dto, entity);
        dto.setControlForm(entity.getControlForm().name());
        dto.setSubject(SubjectDetailsMapper.mapEntityToDto(entity.getRelatedSubject()));
        if (entity.getSignedTeacher() != null) {
            dto.setSignedTeacher(PersonMapper.mapPersonToFullNameIdPair(entity.getSignedTeacher()));
        }
        dto.setPassedAtSemester(entity.getPassedAtSemester());
        return dto;
    }

    public static DisciplineSemesterRecord mapDtoToEntity(DisciplineSemesterRecordDTO dto, Teacher signedTeacher, Subject subject) {
        DisciplineSemesterRecord entity = new DisciplineSemesterRecord();
        RecordBookRecordMapper.updateRecordEntityWithFieldsFromDto(entity, dto);
        entity.setControlForm(ControlForm.valueOf(dto.getControlForm()));
        entity.setRelatedSubject(SubjectDetailsMapper.mapDtoToEntity(dto.getSubject(), signedTeacher, subject));
        entity.setSignedTeacher(signedTeacher);
        entity.setPassedAtSemester(dto.getPassedAtSemester());
        return entity;
    }
}
