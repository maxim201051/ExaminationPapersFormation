package ua.nau.epf.mapper;

import ua.nau.epf.dto.GroupDTO;
import ua.nau.epf.entity.student.Group;
import ua.nau.epf.entity.student.Student;

import java.util.List;

public class GroupMapper {
    public GroupDTO mapEntityToDto(Group entity, List<Student> students) {
        GroupDTO dto = new GroupDTO();
        dto.setId(entity.getId());
        dto.setStudyInfo(GroupStudentStudyInfoMapper.getGroupStudentStudyInfoFromGroup(entity));
        dto.setStudents(PersonMapper.mapPersonListToMap(students));
        return dto;
    }

    public Group mapDtoToEntity(GroupDTO dto) {
        Group entity = new Group();
        entity.setId(dto.getId());
        GroupStudentStudyInfoMapper.setDataFromGroupStudentStudyInfoDTOToGroup(dto.getStudyInfo(), entity);
        return entity;
    }
}
