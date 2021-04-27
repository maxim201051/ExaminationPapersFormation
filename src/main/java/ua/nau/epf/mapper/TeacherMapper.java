package ua.nau.epf.mapper;

import javafx.util.Pair;
import ua.nau.epf.dto.TeacherInfoCardDTO;
import ua.nau.epf.entity.teacher.AcademicDegree;
import ua.nau.epf.entity.teacher.AcademicStatus;
import ua.nau.epf.entity.teacher.Position;
import ua.nau.epf.entity.teacher.Teacher;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TeacherMapper {
    private TeacherMapper() {
    }

    public static TeacherInfoCardDTO mapEntityToDto(Teacher entity) {
        TeacherInfoCardDTO dto = new TeacherInfoCardDTO();
        PersonMapper.updatePersonDtoWithFieldsFromEntity(dto, entity);
        dto.setPosition(entity.getPosition().name());
        dto.setAcademicDegree(entity.getAcademicDegree().name());
        dto.setAcademicStatus(entity.getAcademicStatus().name());
        dto.setHiringDate(entity.getHiringDate());
        dto.setDismissed(entity.isDismissed());
        dto.setDismissalDate(entity.getDismissalDate());
        return dto;
    }

    public static Teacher mapDtoToEntity(TeacherInfoCardDTO dto) {
        Teacher entity = new Teacher();
        PersonMapper.updatePersonEntityWithFieldsFromDto(entity, dto);
        entity.setPosition(Position.valueOf(dto.getPosition()));
        entity.setAcademicDegree(AcademicDegree.valueOf(dto.getAcademicDegree()));
        entity.setAcademicStatus(AcademicStatus.valueOf(dto.getAcademicStatus()));
        entity.setHiringDate(dto.getHiringDate());
        entity.setDismissed(dto.isDismissed());
        entity.setDismissalDate(dto.getDismissalDate());
        return entity;
    }

    /**
     * Note that Teachers in commissionMembers list will have only id after mapping!
     * Other fields will not be filled!
     */
    // todo probably add getting teacher from repo by id
    public static Teacher mapFullNameIdPairToTeacher(Pair<String, Long> teacherPair) {
        Teacher teacher = new Teacher();
        teacher.setId(teacherPair.getValue());
        return teacher;
    }

    /**
     * Note that Persons in list will have only id after mapping!
     * Other fields will not be filled!
     */
    // todo probably add getting person from repo by id
    public static List<Teacher> mapTeacherMapToList(Map<String, Long> teacherMap) {
        List<Teacher> teacherList = new ArrayList<>();
        for (Long id : teacherMap.values()) {
            Teacher teacher = new Teacher();
            teacher.setId(id);
            teacherList.add(teacher);
        }
        return teacherList;
    }
}
