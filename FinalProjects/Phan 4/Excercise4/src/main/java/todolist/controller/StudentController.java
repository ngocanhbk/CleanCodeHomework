package todolist.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import todolist.dto.StudentReqDto;
import todolist.dto.UserResDto;
import todolist.service.StudentService;

@RestController
@RequiredArgsConstructor
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/api/v1/student")
    @ApiOperation("Create student")
    @ApiResponses({ @ApiResponse(code = 200, message = "Create student successfully") })
    public ResponseEntity<UserResDto> createUser(@Valid @RequestBody StudentReqDto studentReqDto) {
        UserResDto response = studentService.saveStudent(studentReqDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
