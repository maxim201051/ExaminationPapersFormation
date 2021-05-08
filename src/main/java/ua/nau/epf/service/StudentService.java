package ua.nau.epf.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.nau.epf.dto.GroupDTO;
import ua.nau.epf.dto.RecordBookRecordDTO;
import ua.nau.epf.dto.StudentInfoCardDTO;
import ua.nau.epf.dto.SubjectDetailsDTO;
import ua.nau.epf.entity.student.Group;
import ua.nau.epf.entity.student.Student;
import ua.nau.epf.entity.student.recordbook.RecordBookRecord;
import ua.nau.epf.entity.user.User;
import ua.nau.epf.exception.QueryReturnedNoResultsException;
import ua.nau.epf.mapper.RecordBookRecordMapper;
import ua.nau.epf.mapper.StudentMapper;
import ua.nau.epf.mapper.SubjectDetailsMapper;
import ua.nau.epf.repository.GroupRepository;
import ua.nau.epf.repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository, GroupRepository groupRepository) {
        this.studentRepository = studentRepository;
    }

    @Transactional
    public StudentInfoCardDTO getStudentDtoById(Long id) throws QueryReturnedNoResultsException {
        return StudentMapper.mapEntityToDto(findStudentById(id));
    }

    private Student findStudentById(Long id) throws QueryReturnedNoResultsException {
        return studentRepository.findById(id).orElseThrow(QueryReturnedNoResultsException::new);
    }

    @Transactional
    public List<StudentInfoCardDTO> findAllStudents() {
        return studentRepository.findAll().stream().map(StudentMapper::mapEntityToDto)
                .collect(Collectors.toList());
    }

    public List<Student> findStudentsByGroupId(Long id) {
        return studentRepository.findAllByGroup_Id(id);
    }

    public List<Student> findStudentsByGroup(GroupDTO groupDTO) {
        return findStudentsByGroupId(groupDTO.getId());
    }

    public Student findStudentByAccount(User account) throws QueryReturnedNoResultsException {
        return studentRepository.findByAccount_Id(account.getId()).orElseThrow(QueryReturnedNoResultsException::new);
    }

    @Transactional
    public List<SubjectDetailsDTO> getAllStudiedDisciplinesByUserAccount(User user) throws QueryReturnedNoResultsException {
        return findStudentByAccount(user).getGroup().getStudiedDisciplines()
                .stream().map(SubjectDetailsMapper::mapEntityToDto).collect(Collectors.toList());
    }


    public List<Student> findStudentsByIds(Map<String, Long> studentMap) throws QueryReturnedNoResultsException {
        List<Student> students = new ArrayList<>();
        for (Long id : studentMap.values()) {
            students.add(findStudentById(id));
        }
        return students;
    }

    @Transactional
    public List<RecordBookRecordDTO> getStudentTailsByAccount(User user) throws QueryReturnedNoResultsException {
        return findStudentByAccount(user).getRecordBook().stream().filter(RecordBookRecord::getHasDebt)
                .map(RecordBookRecordMapper::mapEntityToDto).collect(Collectors.toList());
    }

    @Transactional
    public List<RecordBookRecordDTO> getStudentRecordBookById(User user) throws QueryReturnedNoResultsException {
        return findStudentByAccount(user).getRecordBook().stream().filter(record -> !record.getHasDebt())
                .map(RecordBookRecordMapper::mapEntityToDto).collect(Collectors.toList());
    }

    @Transactional
    public StudentInfoCardDTO saveOrUpdateStudent(StudentInfoCardDTO student, Group group) {
        return StudentMapper.mapEntityToDto(studentRepository.save(
                StudentMapper.mapDtoToEntity(student, group)));//fixme null pointer when group is null
    }
}
