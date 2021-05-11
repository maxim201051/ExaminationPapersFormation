package ua.nau.epf.service;

import javafx.util.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.nau.epf.dto.TeacherInfoCardDTO;
import ua.nau.epf.entity.teacher.Teacher;
import ua.nau.epf.entity.user.User;
import ua.nau.epf.exception.QueryReturnedNoResultsException;
import ua.nau.epf.mapper.TeacherMapper;
import ua.nau.epf.repository.TeacherRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class TeacherService {
    private final TeacherRepository teacherRepository;

    @Autowired
    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Transactional
    public List<TeacherInfoCardDTO> findAllTeachers() {
        return teacherRepository.findAll().stream().map(TeacherMapper::mapEntityToDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public TeacherInfoCardDTO findTeacherDtoById(Long id) throws QueryReturnedNoResultsException {
        return TeacherMapper.mapEntityToDto(findTeacherById(id));
    }

    public Teacher findTeacherByAccount(User account) throws QueryReturnedNoResultsException {
        return teacherRepository.findByAccount_Id(account.getId()).orElseThrow(QueryReturnedNoResultsException::new);
    }

    private Teacher findTeacherById(Long id) throws QueryReturnedNoResultsException {
        return teacherRepository.findById(id).orElseThrow(QueryReturnedNoResultsException::new);
    }

    public Teacher findTeacherById(Pair<String, Long> fullNameIdPair) throws QueryReturnedNoResultsException {
        return findTeacherById(fullNameIdPair.getValue());
    }

    public List<Teacher> findTeachersByIds(Map<String, Long> teacherMap) throws QueryReturnedNoResultsException {
        List<Teacher> teachers = new ArrayList<>();
        for (Long id : teacherMap.values()) {
            teachers.add(findTeacherById(id));
        }
        return teachers;
    }

    public TeacherInfoCardDTO saveOrUpdate(TeacherInfoCardDTO teacherDto) {
        return TeacherMapper.mapEntityToDto(teacherRepository.save(TeacherMapper.mapDtoToEntity(teacherDto)));
    }

    @Transactional
    public TeacherInfoCardDTO findTeacherDtoByAccount(User user) throws QueryReturnedNoResultsException {
        return TeacherMapper.mapEntityToDto(findTeacherByAccount(user));
    }
}
