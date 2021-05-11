package ua.nau.epf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import ua.nau.epf.dto.ExaminationPaperDTO;
import ua.nau.epf.dto.GroupToSubjectRelDTO;
import ua.nau.epf.dto.TeacherInfoCardDTO;
import ua.nau.epf.entity.user.User;
import ua.nau.epf.exception.QueryReturnedNoResultsException;
import ua.nau.epf.service.GroupService;
import ua.nau.epf.service.StudentService;
import ua.nau.epf.service.SubjectService;
import ua.nau.epf.service.TeacherService;

import java.util.List;

@RestController
@RequestMapping("/teacher")
public class TeacherController {
    private final GroupService groupService;
    private final TeacherService teacherService;
    private final SubjectService subjectService;
    private final StudentService studentService;

    @Autowired
    public TeacherController(GroupService groupService, TeacherService teacherService, SubjectService subjectService,
                             StudentService studentService) {
        this.groupService = groupService;
        this.teacherService = teacherService;
        this.subjectService = subjectService;
        this.studentService = studentService;
    }

    @GetMapping("/my-info")
    public ResponseEntity<TeacherInfoCardDTO> findCurrentTeacher(@AuthenticationPrincipal User user) {
        ResponseEntity<TeacherInfoCardDTO> responseEntity;
        try {
            responseEntity = new ResponseEntity<>(teacherService.findTeacherDtoByAccount(user), HttpStatus.OK);
        } catch (QueryReturnedNoResultsException e) {
            responseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }

    @GetMapping("/taught-groups")
    @Transactional
    public ResponseEntity<List<GroupToSubjectRelDTO>> findGroupsWhereCurrentTeacherTaught(@AuthenticationPrincipal User user) {
        ResponseEntity<List<GroupToSubjectRelDTO>> responseEntity;
        try {
            responseEntity = new ResponseEntity<>(
                    groupService.findGroupsBySubjectDetails(
                            subjectService.findSubjectDetailsByTeacher(
                                    teacherService.findTeacherByAccount(user))
                    ), HttpStatus.OK);
        } catch (QueryReturnedNoResultsException e) {
            responseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }

    @GetMapping("/examination-paper")
    public ResponseEntity<ExaminationPaperDTO> findExaminationPaper(@RequestParam Long groupId,
                                                                    @RequestParam Long subjectDetailsId,
                                                                    @RequestParam Integer semester,
                                                                    @RequestParam String type) {
        ResponseEntity<ExaminationPaperDTO> responseEntity;
        try {
            responseEntity = new ResponseEntity<>(subjectService.findExaminationPaperForGroupAndSubject(
                    groupId, subjectDetailsId, semester, type), HttpStatus.OK);
        } catch (QueryReturnedNoResultsException e) {
            responseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }

    @PutMapping("/examination-paper")
    public ResponseEntity<ExaminationPaperDTO> editExaminationPaperForGroupAndSubject(
            @RequestBody ExaminationPaperDTO examinationPaperDTO) {
        ResponseEntity<ExaminationPaperDTO> responseEntity;
        try {
            responseEntity = new ResponseEntity<>(subjectService.updateExaminationPaper(
                    examinationPaperDTO, groupService.findGroupById(examinationPaperDTO.getGroup()),
                    teacherService.findTeacherById(examinationPaperDTO.getResponsibleTeacher())), HttpStatus.OK);
        } catch (QueryReturnedNoResultsException e) {
            responseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }

    /*@GetMapping("/mystudentswithtails")
    public ResponseEntity<> findCurrentTeacherStudentsWithTails(@AuthenticationPrincipal User user) {
        return new ResponseEntity<>(studentService., HttpStatus.OK);
    }*/
}
