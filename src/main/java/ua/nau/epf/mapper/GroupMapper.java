package ua.nau.epf.mapper;

import javafx.util.Pair;
import ua.nau.epf.dto.GroupDTO;
import ua.nau.epf.entity.student.Group;
import ua.nau.epf.entity.student.Student;
import ua.nau.epf.entity.teacher.Teacher;

import java.util.List;

public class GroupMapper {
    public static GroupDTO mapEntityToDto(Group entity, List<Student> students) {
        GroupDTO dto = new GroupDTO();
        dto.setId(entity.getId());
        dto.setGroupNumber(entity.getGroupNumber());
        dto.setStudyInfo(GroupStudentStudyInfoMapper.getGroupStudentStudyInfoFromGroup(entity));
        dto.setStudents(PersonMapper.mapPersonListToMap(students));
        return dto;
    }

    public static Group mapDtoToEntity(GroupDTO dto, Teacher curator) {
        Group entity = new Group();
        entity.setId(dto.getId());
        entity.setGroupNumber(dto.getGroupNumber());
        GroupStudentStudyInfoMapper.setDataFromGroupStudentStudyInfoDTOToGroup(dto.getStudyInfo(), entity, curator);
        return entity;
    }

    public static Pair<String, Long> mapGroupToGroupNumberIdPair(Group group) {
        return new Pair<>(group.getGroupNumber(), group.getId());
    }
}
