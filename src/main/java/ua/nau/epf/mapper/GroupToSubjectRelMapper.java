package ua.nau.epf.mapper;

import javafx.util.Pair;
import ua.nau.epf.dto.GroupToSubjectRelDTO;
import ua.nau.epf.entity.SemesterSubjectDetails;
import ua.nau.epf.entity.student.Group;
import ua.nau.epf.util.DateUtils;

public class GroupToSubjectRelMapper {
    public static GroupToSubjectRelDTO mapEntityToDto(Group group, SemesterSubjectDetails subjectDetails) {
        GroupToSubjectRelDTO dto = new GroupToSubjectRelDTO();
        dto.setGroup(GroupMapper.mapGroupToGroupNumberIdPair(group));
        dto.setSubject(new Pair<>(subjectDetails.getSubject().getName(), subjectDetails.getId()));
        dto.setSemester(DateUtils.calculateCurrentSemester(group.getCourse()));
        return dto;
    }
}
