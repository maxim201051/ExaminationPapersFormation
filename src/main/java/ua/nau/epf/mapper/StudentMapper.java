package ua.nau.epf.mapper;

import javafx.util.Pair;
import ua.nau.epf.dto.StudentInfoCardDTO;
import ua.nau.epf.entity.student.Group;
import ua.nau.epf.entity.student.Student;

import java.util.List;
import java.util.Map;

public class StudentMapper {
    private StudentMapper() {
    }

    public static StudentInfoCardDTO mapEntityToDto(Student entity) {
        StudentInfoCardDTO dto = new StudentInfoCardDTO();
        PersonMapper.updatePersonDtoWithFieldsFromEntity(dto, entity);
        dto.setStudentCode(entity.getStudentCode());
        Group group = entity.getGroup();
        dto.setGroup(new Pair<>(group.getGroupNumber(), group.getId()));
        dto.setStudyInfo(GroupStudentStudyInfoMapper.getGroupStudentStudyInfoFromGroup(entity.getGroup()));
        return dto;
    }

    public static Student mapDtoToEntity(StudentInfoCardDTO dto) {
        Student entity = new Student();
        PersonMapper.updatePersonEntityWithFieldsFromDto(entity, dto);
        entity.setStudentCode(dto.getStudentCode());
        return entity;
    }

    public static List<Student> mapStudentMapToList(Map<String, Long> studentMap) {
        return null;    //todo
        /*return studentMap.values().stream()
                .map(student -> studentRepository.findById(student))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());*/
    }
}
