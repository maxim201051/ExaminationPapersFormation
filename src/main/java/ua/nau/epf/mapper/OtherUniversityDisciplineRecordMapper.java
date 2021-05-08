package ua.nau.epf.mapper;

import ua.nau.epf.dto.OtherUniversityDisciplineRecordDTO;
import ua.nau.epf.entity.Subject;
import ua.nau.epf.entity.student.recordbook.ControlForm;
import ua.nau.epf.entity.student.recordbook.OtherUniversityDisciplineRecord;
import ua.nau.epf.entity.teacher.Teacher;

public class OtherUniversityDisciplineRecordMapper {
    public static OtherUniversityDisciplineRecordDTO mapEntityToDto(OtherUniversityDisciplineRecord entity) {
        OtherUniversityDisciplineRecordDTO dto = new OtherUniversityDisciplineRecordDTO();
        RecordBookRecordMapper.updateRecordDtoWithFieldsFromEntity(dto, entity);
        dto.setSubject(SubjectDetailsMapper.mapEntityToDto(entity.getSubject()));
        dto.setControlForm(entity.getControlForm().name());
        dto.setUniversityName(entity.getUniversityName());
        dto.setCertificateDocumentName(entity.getCertificateDocumentName());
        dto.setCertificateDocumentNumber(entity.getCertificateDocumentNumber());
        dto.setCreditNumber(entity.getCreditNumber());
        dto.setConfirmingTeacher(PersonMapper.mapPersonToFullNameIdPair(entity.getConfirmingTeacher()));
        return dto;
    }

    public static OtherUniversityDisciplineRecord mapDtoToEntity(OtherUniversityDisciplineRecordDTO dto,
                                                                 Teacher confirmingTeacher, Subject subject) {
        OtherUniversityDisciplineRecord entity = new OtherUniversityDisciplineRecord();
        RecordBookRecordMapper.updateRecordEntityWithFieldsFromDto(entity, dto);
        entity.setSubject(SubjectDetailsMapper.mapDtoToEntity(dto.getSubject(), confirmingTeacher, subject));
        entity.setControlForm(ControlForm.valueOf(dto.getControlForm()));
        entity.setUniversityName(dto.getUniversityName());
        entity.setCertificateDocumentName(dto.getCertificateDocumentName());
        entity.setCertificateDocumentNumber(dto.getCertificateDocumentNumber());
        entity.setCreditNumber(dto.getCreditNumber());
        entity.setConfirmingTeacher(confirmingTeacher);
        return entity;
    }
}
