package ua.nau.epf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import ua.nau.epf.dto.*;
import ua.nau.epf.entity.user.User;
import ua.nau.epf.exception.QueryReturnedNoResultsException;
import ua.nau.epf.mapper.UserMapper;
import ua.nau.epf.service.AdminHelpRequestService;
import ua.nau.epf.service.GroupService;
import ua.nau.epf.service.StudentService;
import ua.nau.epf.service.TeacherService;

import java.util.List;

@RestController()
@RequestMapping("/general")
public class GeneralController {
    private final StudentService studentService;
    private final GroupService groupService;
    private final TeacherService teacherService;
    private final AdminHelpRequestService adminHelpRequestService;

    @Autowired
    public GeneralController(StudentService studentService, GroupService groupService, TeacherService teacherService,
                             AdminHelpRequestService adminHelpRequestService) {
        this.studentService = studentService;
        this.groupService = groupService;
        this.teacherService = teacherService;
        this.adminHelpRequestService = adminHelpRequestService;
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<StudentInfoCardDTO> findStudentById(@PathVariable("id") Long id) {
        ResponseEntity<StudentInfoCardDTO> responseEntity;
        try {
            responseEntity = new ResponseEntity<>(studentService.getStudentDtoById(id), HttpStatus.OK);
        } catch (QueryReturnedNoResultsException e) {
            responseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }

    @GetMapping("/student/all")
    public ResponseEntity<List<StudentInfoCardDTO>> findAllStudents() {
        return new ResponseEntity<>(studentService.findAllStudents(), HttpStatus.OK);
    }

    @GetMapping("/group/{id}")
    public ResponseEntity<GroupDTO> findGroupById(@PathVariable("id") Long id) {
        ResponseEntity<GroupDTO> responseEntity;
        try {
            responseEntity = new ResponseEntity<>(
                    groupService.getGroupDtoById(id, studentService.findStudentsByGroupId(id)), HttpStatus.OK);
        } catch (QueryReturnedNoResultsException e) {
            responseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }

    @GetMapping("/group/all")
    public ResponseEntity<List<GroupDTO>> findAllGroups() {
        return new ResponseEntity<>(groupService.findAllGroups(), HttpStatus.OK);
    }

    @GetMapping("/teacher/all")
    public ResponseEntity<List<TeacherInfoCardDTO>> findAllTeachers() {
        return new ResponseEntity<>(teacherService.findAllTeachers(), HttpStatus.OK);
    }

    @GetMapping("/teacher/{id}")
    public ResponseEntity<TeacherInfoCardDTO> findTeacherById(@PathVariable("id") Long id) {
        ResponseEntity<TeacherInfoCardDTO> responseEntity;
        try {
            responseEntity = new ResponseEntity<>(teacherService.findTeacherDtoById(id), HttpStatus.OK);
        } catch (QueryReturnedNoResultsException e) {
            responseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }

    @PostMapping("/admin-help-request")
    public ResponseEntity<AdminHelpRequestDTO> addAdminHelpRequest(@RequestBody AdminHelpRequestDTO adminHelpRequestDTO) {
        ResponseEntity<AdminHelpRequestDTO> responseEntity;
        try {
            responseEntity = new ResponseEntity<>(adminHelpRequestService.saveAdminHelpRequest(adminHelpRequestDTO), HttpStatus.CREATED);
        } catch (QueryReturnedNoResultsException e) {
            responseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Throwable t) {
            t.printStackTrace();
            responseEntity = new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @GetMapping("/user")
    public ResponseEntity<UserDTO> getCurrentUser(@AuthenticationPrincipal User user) {
        return new ResponseEntity<>(UserMapper.mapEntityToDto(user), HttpStatus.OK);
    }
}
