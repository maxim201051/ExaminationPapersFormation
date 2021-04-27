package ua.nau.epf.mapper;

import javafx.util.Pair;
import ua.nau.epf.dto.TeacherInfoCardDTO;
import ua.nau.epf.entity.teacher.AcademicDegree;
import ua.nau.epf.entity.teacher.AcademicStatus;
import ua.nau.epf.entity.teacher.Position;
import ua.nau.epf.entity.teacher.Teacher;

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

    public static Teacher mapFullNameIdPairToTeacher(Pair<String, Long> teacherPair) {
        return null;    //todo
        //return teacherRepository.findById(teacherPair.getValue()).orElse(null);
    }

    public static List<Teacher> mapTeacherMapToList(Map<String, Long> teacherMap) {
        return null;    //todo
        /*return teacherMap.values().stream()
                .map(teacher -> teacherRepository.findById(teacher))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());*/
    }
}
