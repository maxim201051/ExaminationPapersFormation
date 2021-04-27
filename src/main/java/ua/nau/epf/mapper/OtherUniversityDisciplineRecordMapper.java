package ua.nau.epf.mapper;

import ua.nau.epf.dto.OtherUniversityDisciplineRecordDTO;
import ua.nau.epf.entity.student.recordbook.ControlForm;
import ua.nau.epf.entity.student.recordbook.OtherUniversityDisciplineRecord;

public class OtherUniversityDisciplineRecordMapper {
    public OtherUniversityDisciplineRecordDTO mapEntityToDto(OtherUniversityDisciplineRecord entity) {
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

    public OtherUniversityDisciplineRecord mapDtoToEntity(OtherUniversityDisciplineRecordDTO dto) {
        OtherUniversityDisciplineRecord entity = new OtherUniversityDisciplineRecord();
        RecordBookRecordMapper.updateRecordEntityWithFieldsFromDto(entity, dto);
        entity.setSubject(SubjectDetailsMapper.mapDtoToEntity(dto.getSubject()));
        entity.setControlForm(ControlForm.valueOf(dto.getControlForm()));
        entity.setUniversityName(dto.getUniversityName());
        entity.setCertificateDocumentName(dto.getCertificateDocumentName());
        entity.setCertificateDocumentNumber(dto.getCertificateDocumentNumber());
        entity.setCreditNumber(dto.getCreditNumber());
        entity.setConfirmingTeacher(TeacherMapper.mapFullNameIdPairToTeacher(dto.getConfirmingTeacher()));
        return entity;
    }
}
