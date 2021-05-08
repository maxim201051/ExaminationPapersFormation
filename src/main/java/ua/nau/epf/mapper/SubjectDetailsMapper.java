package ua.nau.epf.mapper;

import javafx.util.Pair;
import ua.nau.epf.dto.SubjectDetailsDTO;
import ua.nau.epf.entity.SemesterSubjectDetails;
import ua.nau.epf.entity.Subject;
import ua.nau.epf.entity.student.recordbook.ControlForm;
import ua.nau.epf.entity.teacher.Teacher;

public class SubjectDetailsMapper {
    private SubjectDetailsMapper() {
    }

    public static SubjectDetailsDTO mapEntityToDto(SemesterSubjectDetails entity) {
        SubjectDetailsDTO dto = new SubjectDetailsDTO();
        dto.setId(entity.getId());
        dto.setTotalHours(entity.getTotalHours());
        dto.setLecturesHours(entity.getLecturesHours());
        dto.setPracticeHours(entity.getPracticeHours());
        dto.setLabWorkHours(entity.getLabWorkHours());
        dto.setSelfAndControlWorkHours(entity.getSelfAndControlWorkHours());
        dto.setResponsibleTeacher(PersonMapper.mapPersonToFullNameIdPair(entity.getResponsibleTeacher()));
        dto.setHasCourseWork(entity.getHasCourseWork());
        Subject subject = entity.getSubject();
        dto.setSubject(new Pair<>(subject.getName(), subject.getId()));
        dto.setControlForm(entity.getControlForm().name());
        dto.setCreditNumber(entity.getCreditNumber());
        return dto;
    }

    public static SemesterSubjectDetails mapDtoToEntity(SubjectDetailsDTO dto, Teacher responsibleTeacher, Subject subject) {
        SemesterSubjectDetails entity = new SemesterSubjectDetails();
        entity.setId(dto.getId());
        entity.setTotalHours(dto.getTotalHours());
        entity.setLecturesHours(dto.getLecturesHours());
        entity.setPracticeHours(dto.getPracticeHours());
        entity.setLabWorkHours(dto.getLabWorkHours());
        entity.setSelfAndControlWorkHours(dto.getSelfAndControlWorkHours());
        entity.setResponsibleTeacher(responsibleTeacher);
        entity.setHasCourseWork(dto.getHasCourseWork());
        entity.setSubject(subject);
        entity.setControlForm(ControlForm.valueOf(dto.getControlForm()));
        entity.setCreditNumber(dto.getCreditNumber());
        return entity;
    }
}
