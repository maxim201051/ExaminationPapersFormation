package ua.nau.epf.mapper;

import ua.nau.epf.dto.GroupStudentStudyInfoDTO;
import ua.nau.epf.entity.student.EducationForm;
import ua.nau.epf.entity.student.EducationalDegree;
import ua.nau.epf.entity.student.Group;

public class GroupStudentStudyInfoMapper {
    private GroupStudentStudyInfoMapper() {
    }

    public static GroupStudentStudyInfoDTO getGroupStudentStudyInfoFromGroup(Group group) {
        GroupStudentStudyInfoDTO dto = new GroupStudentStudyInfoDTO();
        dto.setGroupNumber(group.getGroupNumber());
        dto.setCourse(group.getCourse());
        dto.setEducationalDegree(group.getEducationalDegree().name());
        dto.setKnowledgeBranch(group.getKnowledgeBranch());
        dto.setSpeciality(group.getSpeciality());
        dto.setSpecialization(group.getSpecialization());
        dto.setEducationForm(group.getEducationForm().name());
        dto.setStartOfStudy(group.getStartOfStudy());
        dto.setGraduated(group.isGraduated());
        dto.setEndOfStudy(group.getGraduationDate());
        dto.setCurator(PersonMapper.mapPersonToFullNameIdPair(group.getCurator()));
        return dto;
    }

    public static Group setDataFromGroupStudentStudyInfoDTOToGroup(GroupStudentStudyInfoDTO dto, Group group) {
        group.setGroupNumber(dto.getGroupNumber());
        group.setCourse(dto.getCourse());
        group.setEducationalDegree(EducationalDegree.valueOf(dto.getEducationalDegree()));
        group.setKnowledgeBranch(dto.getKnowledgeBranch());
        group.setSpeciality(dto.getSpeciality());
        group.setSpecialization(dto.getSpecialization());
        group.setEducationForm(EducationForm.valueOf(dto.getEducationForm()));
        group.setStartOfStudy(dto.getStartOfStudy());
        group.setGraduated(dto.isGraduated());
        group.setGraduationDate(dto.getEndOfStudy());
        group.setCurator(TeacherMapper.mapFullNameIdPairToTeacher(dto.getCurator()));
        return group;
    }
}
