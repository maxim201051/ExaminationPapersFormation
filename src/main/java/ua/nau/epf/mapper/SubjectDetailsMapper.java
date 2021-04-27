package ua.nau.epf.mapper;

import javafx.util.Pair;
import ua.nau.epf.dto.SubjectDetailsDTO;
import ua.nau.epf.entity.SemesterSubjectDetails;
import ua.nau.epf.entity.Subject;

public class SubjectDetailsMapper {
    private SubjectDetailsMapper() {
    }

    public static SubjectDetailsDTO mapEntityToDto(SemesterSubjectDetails entity) {
        SubjectDetailsDTO dto = new SubjectDetailsDTO();
        dto.setTotalHours(entity.getTotalHours());
        dto.setLecturesHours(entity.getLecturesHours());
        dto.setPracticeHours(entity.getPracticeHours());
        dto.setLabWorkHours(entity.getLabWorkHours());
        dto.setSelfAndControlWorkHours(entity.getSelfAndControlWorkHours());
        dto.setResponsibleTeacher(PersonMapper.mapPersonToFullNameIdPair(entity.getResponsibleTeacher()));
        dto.setHasCourseWork(entity.isHasCourseWork());
        Subject subject = entity.getSubject();
        dto.setSubject(new Pair<>(subject.getName(), subject.getId()));
        return dto;
    }

    /**
     * Note that responsibleTeacher will have only id after mapping!
     * Other fields will not be filled!
     */
    public static SemesterSubjectDetails mapDtoToEntity(SubjectDetailsDTO dto) {
        SemesterSubjectDetails entity = new SemesterSubjectDetails();
        entity.setTotalHours(dto.getTotalHours());
        entity.setLecturesHours(dto.getLecturesHours());
        entity.setPracticeHours(dto.getPracticeHours());
        entity.setLabWorkHours(dto.getLabWorkHours());
        entity.setSelfAndControlWorkHours(dto.getSelfAndControlWorkHours());
        entity.setResponsibleTeacher(TeacherMapper.mapFullNameIdPairToTeacher(dto.getResponsibleTeacher()));
        entity.setHasCourseWork(dto.isHasCourseWork());
        Subject subject = new Subject();
        subject.setId(dto.getSubject().getValue());
        subject.setName(dto.getSubject().getKey());
        entity.setSubject(subject);
        return entity;
    }
}
