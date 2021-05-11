package ua.nau.epf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.nau.epf.dto.RecordBookRecordDTO;
import ua.nau.epf.dto.StudentInfoCardDTO;
import ua.nau.epf.dto.SubjectDetailsDTO;
import ua.nau.epf.entity.user.User;
import ua.nau.epf.exception.QueryReturnedNoResultsException;
import ua.nau.epf.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/my-info")
    public ResponseEntity<StudentInfoCardDTO> findCurrentStudent(@AuthenticationPrincipal User user) {
        ResponseEntity<StudentInfoCardDTO> responseEntity;
        try {
            responseEntity = new ResponseEntity<>(studentService.findStudentDtoByAccount(user), HttpStatus.OK);
        } catch (QueryReturnedNoResultsException e) {
            responseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }

    @GetMapping("/record-book")
    public ResponseEntity<List<RecordBookRecordDTO>> findCurrentStudentRecordBook(@AuthenticationPrincipal User user) {
        ResponseEntity<List<RecordBookRecordDTO>> responseEntity;
        try {
            responseEntity = new ResponseEntity<>(studentService.getStudentRecordBookById(user), HttpStatus.OK);
        } catch (QueryReturnedNoResultsException e) {
            responseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }

    @GetMapping("/my-disciplines")
    public ResponseEntity<List<SubjectDetailsDTO>> findCurrentStudentDisciplines(@AuthenticationPrincipal User user) {
        ResponseEntity<List<SubjectDetailsDTO>> responseEntity;
        try {
            responseEntity = new ResponseEntity<>(studentService.getAllStudiedDisciplinesByUserAccount(user),
                    HttpStatus.OK);
        } catch (QueryReturnedNoResultsException e) {
            responseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }

    @GetMapping("/my-tails") //fixme return type
    public ResponseEntity<List<RecordBookRecordDTO>> findCurrentStudentTails(@AuthenticationPrincipal User user) {
        ResponseEntity<List<RecordBookRecordDTO>> responseEntity;
        try {
            responseEntity = new ResponseEntity<>(studentService.getStudentTailsByAccount(user), HttpStatus.OK);
        } catch (QueryReturnedNoResultsException e) {
            responseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }
}
