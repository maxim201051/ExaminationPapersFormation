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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class GroupService {
    private final GroupRepository groupRepository;

    @Autowired
    public GroupService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
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
    public GroupDTO addGroup(GroupDTO group, Teacher curator) {
        return saveOrUpdate(group, curator, Collections.emptyList());
    }

    @Transactional
    public GroupDTO updateGroup(GroupDTO group, Teacher curator, List<Student> students) {
        return saveOrUpdate(group, curator, students);
    }

    @Transactional
    public GroupDTO saveOrUpdate(GroupDTO group, Teacher curator, List<Student> students) {
        return GroupMapper.mapEntityToDto(groupRepository.save(GroupMapper.mapDtoToEntity(group, curator)), students);
    }

    @Transactional
    public Group findGroupById(Pair<String, Long> groupNumberIdPair) throws QueryReturnedNoResultsException { //fixme pair can be null
        return findGroupById(groupNumberIdPair.getValue());
    }
}
