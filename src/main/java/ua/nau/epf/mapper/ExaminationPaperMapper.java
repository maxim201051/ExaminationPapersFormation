package ua.nau.epf.mapper;

import javafx.util.Pair;
import ua.nau.epf.dto.ExaminationPaperDTO;
import ua.nau.epf.dto.StudentDisciplineRecordDTO;
import ua.nau.epf.entity.SemesterSubjectDetails;
import ua.nau.epf.entity.student.Group;
import ua.nau.epf.entity.student.recordbook.ControlForm;
import ua.nau.epf.entity.teacher.ExaminationPaper;
import ua.nau.epf.entity.teacher.Teacher;
import ua.nau.epf.util.DateUtils;

import java.util.List;
import java.util.stream.Collectors;

public class ExaminationPaperMapper {
    public static ExaminationPaperDTO mapEntityToDto(ExaminationPaper entity,
                                                     List<StudentDisciplineRecordDTO> rows) {
        Group group = entity.getGroup();
        ExaminationPaperDTO dto = new ExaminationPaperDTO();
        dto.setId(entity.getId());
        dto.setSpeciality(group.getSpeciality());
        dto.setSpecialization(group.getSpecialization());
        dto.setEducationalYear(entity.getEducationalYearString());
        dto.setSemester(entity.getPassedAtSemester());
        dto.setCourse(DateUtils.getCourseBySemester(entity.getPassedAtSemester()));
        dto.setControlForm(entity.getControlForm().name());
        dto.setResponsibleTeacher(PersonMapper.mapPersonToFullNameIdPair(entity.getResponsibleTeacher()));
        dto.setGroup(GroupMapper.mapGroupToGroupNumberIdPair(group));
        dto.setSubject(new Pair<>(entity.getRelatedSubject().getSubject().getName(), entity.getRelatedSubject().getId()));
        dto.setControlDate(entity.getControlDate());
        dto.setRows(rows);
        return dto;
    }

    public static ExaminationPaper mapDtoToEntity(ExaminationPaperDTO dto, Group group, Teacher responsibleTeacher,
                                                  SemesterSubjectDetails relatedSubject) {
        ExaminationPaper entity = new ExaminationPaper();
        entity.setId(dto.getId());
        entity.setEducationalYearString(dto.getEducationalYear());
        entity.setPassedAtSemester(dto.getSemester());
        entity.setControlForm(ControlForm.valueOf(dto.getControlForm()));
        entity.setResponsibleTeacher(responsibleTeacher);
        entity.setGroup(group);
        entity.setRelatedSubject(relatedSubject);
        entity.setRelatedRecordBookRecords(dto.getRows().stream().map(StudentDisciplineRecordDTO::getRecord)
                .map(record -> DisciplineSemesterRecordMapper.mapDtoToEntity(record, responsibleTeacher, relatedSubject.getSubject()))
                .collect(Collectors.toList()));
        entity.setControlDate(dto.getControlDate());
        return entity;
    }
}
