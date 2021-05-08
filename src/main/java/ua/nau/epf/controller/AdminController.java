package ua.nau.epf.controller;

import javafx.util.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import ua.nau.epf.dto.*;
import ua.nau.epf.exception.QueryReturnedNoResultsException;
import ua.nau.epf.service.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    private final GroupService groupService;
    private final StudentService studentService;
    private final TeacherService teacherService;
    private final UserService userService;
    private final AdminHelpRequestService adminHelpRequestService;
    private final SubjectService subjectService;

    @Autowired
    public AdminController(GroupService groupService, StudentService studentService, TeacherService teacherService,
                           UserService userService, AdminHelpRequestService adminHelpRequestService,
                           SubjectService subjectService) {
        this.groupService = groupService;
        this.studentService = studentService;
        this.teacherService = teacherService;
        this.userService = userService;
        this.adminHelpRequestService = adminHelpRequestService;
        this.subjectService = subjectService;
    }

    @PostMapping("/teacher")
    @Transactional //fixme transaction doesn't work fine user account addition will not be reverted if teacher not saved
    public ResponseEntity<TeacherInfoCardDTO> addTeacher(@RequestBody TeacherUserDTO teacherUserDTO) {
        ResponseEntity<TeacherInfoCardDTO> responseEntity;
        try {
            teacherUserDTO = userService.addUser(teacherUserDTO);
            responseEntity = new ResponseEntity<>(teacherService.saveOrUpdate(
                    teacherUserDTO.getTeacher()), HttpStatus.CREATED);
        } catch (Exception e) {
            responseEntity = new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @PutMapping("/teacher")
    public ResponseEntity<TeacherInfoCardDTO> updateTeacher(@RequestBody TeacherInfoCardDTO teacher) {
        ResponseEntity<TeacherInfoCardDTO> responseEntity;
        try {
            responseEntity = new ResponseEntity<>(teacherService.saveOrUpdate(teacher), HttpStatus.OK);
        } catch (Exception e) {
            responseEntity = new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @PostMapping("/student")
    @Transactional
    public ResponseEntity<StudentInfoCardDTO> addStudent(@RequestBody StudentUserDTO studentUserDTO) {
        ResponseEntity<StudentInfoCardDTO> responseEntity;
        try {
            studentUserDTO = userService.addUser(studentUserDTO);
            StudentInfoCardDTO studentDto = studentUserDTO.getStudent();
            responseEntity = new ResponseEntity<>(studentService.saveOrUpdateStudent(
                    studentDto, groupService.findGroupById(studentDto.getGroup())), HttpStatus.CREATED);
        } catch (QueryReturnedNoResultsException e) {
            responseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            responseEntity = new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @PutMapping("/student")
    public ResponseEntity<StudentInfoCardDTO> updateStudent(@RequestBody StudentInfoCardDTO studentDto) {
        ResponseEntity<StudentInfoCardDTO> responseEntity;
        try {
            responseEntity = new ResponseEntity<>(studentService.saveOrUpdateStudent(
                    studentDto, groupService.findGroupById(studentDto.getGroup())), HttpStatus.OK);
        } catch (QueryReturnedNoResultsException e) {
            responseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }

    @PostMapping("/group")
    public ResponseEntity<GroupDTO> addGroup(@RequestBody GroupDTO group) {
        ResponseEntity<GroupDTO> responseEntity;
        try {
            responseEntity = new ResponseEntity<>(groupService.addGroup(group,
                    teacherService.findTeacherById(group.getStudyInfo().getCurator())), HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            responseEntity = new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @PutMapping("/group")
    public ResponseEntity<GroupDTO> updateGroup(@RequestBody GroupDTO group) {
        ResponseEntity<GroupDTO> responseEntity;
        try {
            responseEntity = new ResponseEntity<>(groupService.updateGroup(group,
                    teacherService.findTeacherById(group.getStudyInfo().getCurator()),
                    studentService.findStudentsByGroup(group)), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            responseEntity = new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    /*@PostMapping("/group/{id}/practice")
    public ResponseEntity<> addPracticeToGroup(@PathVariable("id") Long id) {
        return new ResponseEntity<>(, HttpStatus.CREATED);
    }

    @PostMapping("/group/{id}/diploma")
    public ResponseEntity<> addDiplomaToGroup(@PathVariable("id") Long id) {
        return new ResponseEntity<>(, HttpStatus.CREATED);
    }

    @PostMapping("/student/{id}/oudr")
    public ResponseEntity<> addOtherUniversityDisciplineRecordToStudent(
            @PathVariable("id") Long id, @RequestBody OtherUniversityDisciplineRecordDTO record) {
        return new ResponseEntity<>(, HttpStatus.CREATED);
    }*/

    @GetMapping("/admin-help-request/{id}")
    public ResponseEntity<AdminHelpRequestDTO> findAdminHelpRequestById(@PathVariable("id") Long id) {
        ResponseEntity<AdminHelpRequestDTO> responseEntity;
        try {
            responseEntity = new ResponseEntity<>(adminHelpRequestService.findAdminHelpRequestById(id), HttpStatus.OK);
        } catch (QueryReturnedNoResultsException e) {
            responseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }

    @GetMapping("/admin-help-request/all")
    public ResponseEntity<List<AdminHelpRequestDTO>> findAdminHelpRequestById() {
        return new ResponseEntity<>(adminHelpRequestService.findAllAdminHelpRequests(), HttpStatus.OK);
    }

    @PutMapping("/admin-help-request")
    public ResponseEntity<AdminHelpRequestDTO> addAdminHelpRequest(@RequestBody AdminHelpRequestDTO adminHelpRequestDTO) {
        ResponseEntity<AdminHelpRequestDTO> responseEntity;
        try {
            responseEntity = new ResponseEntity<>(
                    adminHelpRequestService.saveAdminHelpRequest(adminHelpRequestDTO), HttpStatus.OK);
        } catch (QueryReturnedNoResultsException e) {
            responseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            e.printStackTrace();
            responseEntity = new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @GetMapping("/subject/all")
    public ResponseEntity<List<Pair<String, Long>>> findAllSubjects() {
        return new ResponseEntity<>(subjectService.findAllSubjects(), HttpStatus.OK);
    }

    @PostMapping("/subject")
    public ResponseEntity<List<Pair<String, Long>>> addSubject(@RequestBody String subjectName) {
        ResponseEntity<List<Pair<String, Long>>> responseEntity;
        try {
            responseEntity = new ResponseEntity<>(subjectService.addSubject(subjectName), HttpStatus.CREATED);
        } catch (Exception e) {
            responseEntity = new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @PutMapping("/subject")
    public ResponseEntity<List<Pair<String, Long>>> updateSubject(@RequestBody Pair<String, Long> subject) {
        ResponseEntity<List<Pair<String, Long>>> responseEntity;
        try {
            responseEntity = new ResponseEntity<>(subjectService.updateSubject(subject), HttpStatus.OK);
        } catch (Exception e) {
            responseEntity = new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @PostMapping("/assign-subject-details-to-group")
    @Transactional
    public ResponseEntity<GroupDTO> assignSubjectToGroup(@RequestBody GroupToSubjectRelDTO groupToSubjectRelDTO) {
        ResponseEntity<GroupDTO> responseEntity;
        try {
            responseEntity = new ResponseEntity<>(subjectService.assignSubjectToGroup(groupToSubjectRelDTO,
                    studentService.findStudentsByGroupId(groupToSubjectRelDTO.getGroup().getValue())), HttpStatus.OK);
        } catch (QueryReturnedNoResultsException e) {
            responseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }

    @GetMapping("/subject-details/all")
    public ResponseEntity<List<SubjectDetailsDTO>> findAllSubjectDetails() {
        return new ResponseEntity<>(subjectService.findAllSubjectDetails(), HttpStatus.OK);
    }

    @PostMapping("/subject-details")
    public ResponseEntity<SubjectDetailsDTO> addSubjectDetails(@RequestBody SubjectDetailsDTO subjectDetailsDTO) {
        ResponseEntity<SubjectDetailsDTO> responseEntity;
        try {
            responseEntity = new ResponseEntity<>(subjectService.saveOrUpdateSubjectDetails(subjectDetailsDTO),
                    HttpStatus.CREATED);
        } catch (QueryReturnedNoResultsException e) {
           responseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            responseEntity = new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @PutMapping("/subject-details")
    public ResponseEntity<SubjectDetailsDTO> updateSubjectDetails(@RequestBody SubjectDetailsDTO subjectDetailsDTO) {
        ResponseEntity<SubjectDetailsDTO> responseEntity;
        try {
            responseEntity = new ResponseEntity<>(subjectService.saveOrUpdateSubjectDetails(subjectDetailsDTO),
                    HttpStatus.OK);
        } catch (QueryReturnedNoResultsException e) {
            responseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            responseEntity = new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

}
