package ua.nau.epf.mapper;

import javafx.util.Pair;
import ua.nau.epf.dto.StudentInfoCardDTO;
import ua.nau.epf.entity.student.Group;
import ua.nau.epf.entity.student.Student;

public class StudentMapper {
    private StudentMapper() {
    }

    public static StudentInfoCardDTO mapEntityToDto(Student entity) {
        StudentInfoCardDTO dto = new StudentInfoCardDTO();
        PersonMapper.updatePersonDtoWithFieldsFromEntity(dto, entity);
        dto.setStudentCode(entity.getStudentCode());
        Group group = entity.getGroup();
        if (group != null) {
            dto.setGroup(new Pair<>(group.getGroupNumber(), group.getId()));
            dto.setStudyInfo(GroupStudentStudyInfoMapper.getGroupStudentStudyInfoFromGroup(entity.getGroup()));
        }
        return dto;
    }

    public static Student mapDtoToEntity(StudentInfoCardDTO dto, Group group) {
        Student entity = new Student();
        PersonMapper.updatePersonEntityWithFieldsFromDto(entity, dto);
        entity.setStudentCode(dto.getStudentCode());
        entity.setGroup(group);
        return entity;
    }
}
