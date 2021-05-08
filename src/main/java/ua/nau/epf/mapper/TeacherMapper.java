package ua.nau.epf.mapper;

import ua.nau.epf.dto.TeacherInfoCardDTO;
import ua.nau.epf.entity.teacher.AcademicDegree;
import ua.nau.epf.entity.teacher.AcademicStatus;
import ua.nau.epf.entity.teacher.Position;
import ua.nau.epf.entity.teacher.Teacher;

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
        dto.setDismissed(entity.getDismissed());
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
        entity.setDismissed(dto.getDismissed());
        entity.setDismissalDate(dto.getDismissalDate());
        return entity;
    }
}
