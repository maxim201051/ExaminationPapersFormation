package ua.nau.epf.mapper;

import ua.nau.epf.dto.GroupStudentStudyInfoDTO;
import ua.nau.epf.entity.student.EducationForm;
import ua.nau.epf.entity.student.EducationalDegree;
import ua.nau.epf.entity.student.Group;
import ua.nau.epf.entity.teacher.Teacher;

public class GroupStudentStudyInfoMapper {
    private GroupStudentStudyInfoMapper() {
    }

    public static GroupStudentStudyInfoDTO getGroupStudentStudyInfoFromGroup(Group group) {
        GroupStudentStudyInfoDTO dto = new GroupStudentStudyInfoDTO();
        dto.setCourse(group.getCourse());
        dto.setEducationalDegree(group.getEducationalDegree().name());
        dto.setKnowledgeBranch(group.getKnowledgeBranch());
        dto.setSpeciality(group.getSpeciality());
        dto.setSpecialization(group.getSpecialization());
        dto.setEducationForm(group.getEducationForm().name());
        dto.setStartOfStudy(group.getStartOfStudy());
        dto.setGraduated(group.getGraduated());
        dto.setEndOfStudy(group.getGraduationDate());
        dto.setCurator(PersonMapper.mapPersonToFullNameIdPair(group.getCurator()));
        return dto;
    }

    public static Group setDataFromGroupStudentStudyInfoDTOToGroup(GroupStudentStudyInfoDTO dto, Group group, Teacher curator) {
        group.setCourse(dto.getCourse());
        group.setEducationalDegree(EducationalDegree.valueOf(dto.getEducationalDegree()));
        group.setKnowledgeBranch(dto.getKnowledgeBranch());
        group.setSpeciality(dto.getSpeciality());
        group.setSpecialization(dto.getSpecialization());
        group.setEducationForm(EducationForm.valueOf(dto.getEducationForm()));
        group.setStartOfStudy(dto.getStartOfStudy());
        group.setGraduated(dto.getGraduated());
        group.setGraduationDate(dto.getEndOfStudy());
        group.setCurator(curator);
        return group;
    }
}
