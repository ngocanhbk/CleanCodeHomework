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
import todolist.dto.UserRequestDto;
import todolist.dto.UserResDto;
import todolist.service.StudentService;
import todolist.service.TeacherService;
import todolist.service.UserService;

@RestController
@RequiredArgsConstructor
public class UserController {

    @Autowired
    StudentService studentService;

    @Autowired
    TeacherService teacherService;

    @PostMapping("/api/v1/create-user")
    @ApiOperation("Create user")
    @ApiResponses({ @ApiResponse(code = 200, message = "Create user successfully") })
    public ResponseEntity<UserResDto> createUser(@Valid @RequestBody UserRequestDto userRequestDto) {
        UserService userService = createTypeService(userRequestDto.getMode());
        UserResDto response = userService.createUser(userRequestDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    public UserService createTypeService(String mode) {
        if ("STUDENT".equals(mode)) {
            return studentService;
        } else if ("TEACHER".equals(mode)) {
            return teacherService;
        } else {
            throw new IllegalArgumentException("Invalid mode");
        }
    }
}
