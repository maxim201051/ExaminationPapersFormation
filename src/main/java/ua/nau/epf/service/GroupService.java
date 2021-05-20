package ua.nau.epf.service;

import javafx.util.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.nau.epf.dto.GroupDTO;
import ua.nau.epf.dto.GroupToSubjectRelDTO;
import ua.nau.epf.entity.SemesterSubjectDetails;
import ua.nau.epf.entity.student.Group;
import ua.nau.epf.entity.student.Student;
import ua.nau.epf.entity.teacher.Teacher;
import ua.nau.epf.exception.QueryReturnedNoResultsException;
import ua.nau.epf.mapper.GroupMapper;
import ua.nau.epf.mapper.GroupToSubjectRelMapper;
import ua.nau.epf.repository.GroupRepository;
import ua.nau.epf.repository.StudentRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GroupService {
    private final GroupRepository groupRepository;
    private final StudentRepository studentRepository;

    @Autowired
    public GroupService(GroupRepository groupRepository, StudentRepository studentRepository) {
        this.groupRepository = groupRepository;
        this.studentRepository = studentRepository;
    }

    private Group findGroupById(Long id) throws QueryReturnedNoResultsException {
        return groupRepository.findById(id)
                .orElseThrow(QueryReturnedNoResultsException::new);
    }

    public List<GroupToSubjectRelDTO> findGroupsBySubjectDetails(List<SemesterSubjectDetails> subjectDetails) {
        List<GroupToSubjectRelDTO> groupToSubjectRelDTOList = new ArrayList<>();
        for (SemesterSubjectDetails details : subjectDetails) {
            Optional<Group> group = groupRepository.findByStudiedDisciplinesContains(details);
            group.ifPresent(value -> groupToSubjectRelDTOList.add(GroupToSubjectRelMapper.mapEntityToDto(value, details)));
        }
        return groupToSubjectRelDTOList;
    }

    @Transactional
    public GroupDTO getGroupDtoById(Long id, List<Student> groupStudents) throws QueryReturnedNoResultsException {
        return GroupMapper.mapEntityToDto(findGroupById(id), groupStudents);
    }

    @Transactional
    public Long addGroup(GroupDTO group, Teacher curator) {
        return saveOrUpdate(group, curator).getId();
    }

    @Transactional
    public Long updateGroup(GroupDTO group, Teacher curator) {
        return saveOrUpdate(group, curator).getId();
    }

    @Transactional
    public Group saveOrUpdate(GroupDTO group, Teacher curator) {
        return groupRepository.save(GroupMapper.mapDtoToEntity(group, curator));
    }

    @Transactional
    public Group findGroupById(Pair<String, Long> groupNumberIdPair) throws QueryReturnedNoResultsException { //fixme pair can be null
        return findGroupById(groupNumberIdPair.getValue());
    }

    public List<Student> findStudentsByGroupId(Long id) {
        return studentRepository.findAllByGroup_Id(id);
    }

    @Transactional
    public List<GroupDTO> findAllGroups() {
        return groupRepository.findAll().stream()
                .map(group -> GroupMapper.mapEntityToDto(group, findStudentsByGroupId(group.getId())))
                .collect(Collectors.toList());
    }

    @Transactional
    public List<Pair<String, Long>> findAllGroupsInPairFormat() {
        return groupRepository.findAll().stream()
                .map(GroupMapper::mapGroupToGroupNumberIdPair).collect(Collectors.toList());
    }
}
