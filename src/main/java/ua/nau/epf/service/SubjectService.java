package ua.nau.epf.service;

import javafx.util.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.nau.epf.dto.*;
import ua.nau.epf.entity.SemesterSubjectDetails;
import ua.nau.epf.entity.Subject;
import ua.nau.epf.entity.student.Group;
import ua.nau.epf.entity.student.Student;
import ua.nau.epf.entity.student.recordbook.ControlForm;
import ua.nau.epf.entity.student.recordbook.DisciplineSemesterRecord;
import ua.nau.epf.entity.student.recordbook.ECTSScale;
import ua.nau.epf.entity.student.recordbook.NationalScale;
import ua.nau.epf.entity.teacher.ExaminationPaper;
import ua.nau.epf.entity.teacher.Teacher;
import ua.nau.epf.exception.QueryReturnedNoResultsException;
import ua.nau.epf.mapper.*;
import ua.nau.epf.repository.*;
import ua.nau.epf.util.DateUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SubjectService {
    private final SemesterSubjectDetailsRepository semesterSubjectDetailsRepository;
    private final ExaminationPaperRepository examinationPaperRepository;
    private final StudentRepository studentRepository;
    private final SubjectRepository subjectRepository;
    private final GroupRepository groupRepository;
    private final TeacherRepository teacherRepository;
    private final DisciplineSemesterRecordRepository disciplineSemesterRecordRepository;

    @Autowired
    public SubjectService(SemesterSubjectDetailsRepository semesterSubjectDetailsRepository,
                          ExaminationPaperRepository examinationPaperRepository, StudentRepository studentRepository,
                          SubjectRepository subjectRepository, GroupRepository groupRepository, TeacherRepository teacherRepository,
                          DisciplineSemesterRecordRepository disciplineSemesterRecordRepository) {
        this.semesterSubjectDetailsRepository = semesterSubjectDetailsRepository;
        this.examinationPaperRepository = examinationPaperRepository;
        this.studentRepository = studentRepository;
        this.subjectRepository = subjectRepository;
        this.groupRepository = groupRepository;
        this.teacherRepository = teacherRepository;
        this.disciplineSemesterRecordRepository = disciplineSemesterRecordRepository;
    }

    public List<SemesterSubjectDetails> findSubjectDetailsByTeacher(Teacher teacher) {
        return semesterSubjectDetailsRepository.findAllByResponsibleTeacher_Id(teacher.getId());
    }

    @Transactional
    public ExaminationPaperDTO findExaminationPaperForGroupAndSubject(
            Long groupId, Long subjectId, Integer semester, String type) throws QueryReturnedNoResultsException {
        ExaminationPaper examinationPaper = examinationPaperRepository
                .findByGroup_IdAndRelatedSubject_IdAndPassedAtSemesterAndControlForm(
                        groupId, subjectId, semester, ControlForm.valueOf(type)).orElseThrow(QueryReturnedNoResultsException::new);
        List<StudentDisciplineRecordDTO> rows = getStudentDisciplineRecordDTOForExaminationPaper(examinationPaper);
        return ExaminationPaperMapper.mapEntityToDto(examinationPaper, rows);
    }

    private List<StudentDisciplineRecordDTO> getStudentDisciplineRecordDTOForExaminationPaper(ExaminationPaper examinationPaper) throws QueryReturnedNoResultsException {
        List<DisciplineSemesterRecord> disciplineSemesterRecords = examinationPaper.getRelatedRecordBookRecords();
        List<StudentDisciplineRecordDTO> rows = new ArrayList<>();
        for (DisciplineSemesterRecord record : disciplineSemesterRecords) {
            StudentDisciplineRecordDTO row = new StudentDisciplineRecordDTO();
            Student student = studentRepository.findByRecordBookContains(record)
                    .orElseThrow(QueryReturnedNoResultsException::new);
            row.setStudent(StudentMapper.mapEntityToDto(student));
            row.setRecord(DisciplineSemesterRecordMapper.mapEntityToDto(record));
            rows.add(row);
        }
        return rows;
    }

    @Transactional
    public ExaminationPaperDTO updateExaminationPaper(ExaminationPaperDTO examinationPaperDTO, Group group,
                                                      Teacher responsibleTeacher) throws QueryReturnedNoResultsException {
        SemesterSubjectDetails semesterSubjectDetails = semesterSubjectDetailsRepository.findById(
                examinationPaperDTO.getSubject().getValue()).orElseThrow(QueryReturnedNoResultsException::new);
        ExaminationPaper examinationPaper = ExaminationPaperMapper.mapDtoToEntity(examinationPaperDTO, group,
                responsibleTeacher, semesterSubjectDetails);
        examinationPaper = saveExaminationPaperAndRelatedRecords(examinationPaper);
        return ExaminationPaperMapper.mapEntityToDto(examinationPaper,
                getStudentDisciplineRecordDTOForExaminationPaper(examinationPaper));
    }

    public ExaminationPaper saveExaminationPaperAndRelatedRecords(ExaminationPaper examinationPaper) {
        for (DisciplineSemesterRecord record : examinationPaper.getRelatedRecordBookRecords()) {
            semesterSubjectDetailsRepository.save(record.getRelatedSubject());
            disciplineSemesterRecordRepository.save(record);
        }
        return examinationPaperRepository.save(examinationPaper);
    }

    public List<Pair<String, Long>> findAllSubjects() {
        return subjectRepository.findAll().stream().map(subject -> new Pair<>(subject.getName(), subject.getId()))
                .collect(Collectors.toList());
    }

    public List<Pair<String, Long>> addSubject(String subjectName) {
        Subject subject = new Subject();
        subject.setName(subjectName);
        subjectRepository.save(subject);
        return findAllSubjects();
    }

    public List<Pair<String, Long>> updateSubject(Pair<String, Long> subjectNameIdPair) {
        Subject subject = new Subject();
        subject.setId(subjectNameIdPair.getValue());
        subject.setName(subjectNameIdPair.getKey());
        subjectRepository.save(subject);
        return findAllSubjects();
    }

    public GroupDTO assignSubjectToGroup(GroupToSubjectRelDTO groupToSubjectRelDTO, List<Student> students) throws QueryReturnedNoResultsException {
        Group group = groupRepository.findById(groupToSubjectRelDTO.getGroup().getValue())
                .orElseThrow(QueryReturnedNoResultsException::new);
        SemesterSubjectDetails subjectDetails = semesterSubjectDetailsRepository.findById(
                groupToSubjectRelDTO.getSubject().getValue()).orElseThrow(QueryReturnedNoResultsException::new);
        Teacher teacher = subjectDetails.getResponsibleTeacher();

        if (!group.getStudiedDisciplines().contains(subjectDetails)) {
            group.getStudiedDisciplines().add(subjectDetails);
            groupRepository.save(group);
        }

        addExaminationPaper(group, subjectDetails, teacher, students, subjectDetails.getControlForm());
        if (subjectDetails.getHasCourseWork()) {
            addExaminationPaper(group, subjectDetails, teacher, students, ControlForm.COURSE_WORK);
        }

        return GroupMapper.mapEntityToDto(group, students);
    }

    public void addExaminationPaper(Group group, SemesterSubjectDetails subjectDetails, Teacher teacher,
                                    List<Student> students, ControlForm controlForm) {
        ExaminationPaper examinationPaper = new ExaminationPaper();
        examinationPaper.setEducationalYearString(DateUtils.getCurrentEducationalYear());
        examinationPaper.setPassedAtSemester(DateUtils.calculateCurrentSemester(group.getCourse()));
        examinationPaper.setControlForm(controlForm);
        examinationPaper.setResponsibleTeacher(teacher);
        examinationPaper.setGroup(group);
        examinationPaper.setRelatedSubject(subjectDetails);
        List<DisciplineSemesterRecord> disciplineSemesterRecords = new ArrayList<>();
        for (Student student : students) {
            DisciplineSemesterRecord record = new DisciplineSemesterRecord();
            record.setRelatedSubject(subjectDetails);
            record.setControlForm(controlForm);
            record.setPassedAtSemester(DateUtils.getCourseBySemester(group.getCourse()));
            record.setHasDebt(false);
            student.getRecordBook().add(record);
            disciplineSemesterRecordRepository.save(record);
            studentRepository.save(student);
            disciplineSemesterRecords.add(record);
        }
        examinationPaper.setRelatedRecordBookRecords(disciplineSemesterRecords);
        examinationPaperRepository.save(examinationPaper);
    }

    @Transactional
    public List<SubjectDetailsDTO> findAllSubjectDetails() {
        return semesterSubjectDetailsRepository.findAll().stream().map(SubjectDetailsMapper::mapEntityToDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public SubjectDetailsDTO saveOrUpdateSubjectDetails(SubjectDetailsDTO subjectDetailsDTO) throws QueryReturnedNoResultsException {
        return SubjectDetailsMapper.mapEntityToDto(semesterSubjectDetailsRepository.save(
                SubjectDetailsMapper.mapDtoToEntity(subjectDetailsDTO,
                        teacherRepository.findById(subjectDetailsDTO.getResponsibleTeacher().getValue())
                                .orElseThrow(QueryReturnedNoResultsException::new),
                        subjectRepository.findById(subjectDetailsDTO.getSubject().getValue())
                .orElseThrow(QueryReturnedNoResultsException::new))));
    }
}
