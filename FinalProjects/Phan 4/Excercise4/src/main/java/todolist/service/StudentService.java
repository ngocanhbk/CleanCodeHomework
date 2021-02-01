package todolist.service;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.sun.xml.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

import todolist.dto.StudentReqDto;
import todolist.dto.UserResDto;
import todolist.entity.Student;
import todolist.entity.User;
import todolist.error.ErrorCodes;
import todolist.error.ServiceRuntimeException;
import todolist.repository.StudentRepository;
import todolist.repository.UserRepository;

public class StudentService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    ModelMapper modelMapper;

    @Transactional
    @CachePut(value = "users", key = "#result.id")
    public UserResDto saveStudent(StudentReqDto studentReqDto) {
        List<String> listExistEmail = userRepository.getExistEmail(studentReqDto.getEmail());
        if (!CollectionUtils.isEmpty(listExistEmail)) {
            throw new ServiceRuntimeException(HttpStatus.NOT_FOUND, ErrorCodes.EMAIL_001,
                    String.format("The user with email adress #%s already exists.", studentReqDto.getEmail()));
        }
        User user;
        if (Objects.isNull(studentReqDto.getUserId())) {
            user = new User();
        } else {
            user = userRepository.findById(studentReqDto.getUserId())
                    .orElseThrow(() -> new ServiceRuntimeException(HttpStatus.NOT_FOUND, ErrorCodes.USER_001,
                            String.format("User not found: #%s", studentReqDto.getUserId())));
        }
        modelMapper.map(studentReqDto, user);
        User savedUser = userRepository.save(user);

        Student student = new Student();
        student.setUserId(savedUser.getUserId());
        student.setYear(studentReqDto.getStudent().getYear());

        student = studentRepository.save(student);
        return modelMapper.map(savedUser, UserResDto.class);
    }
}
