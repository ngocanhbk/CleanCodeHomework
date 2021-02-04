package todolist.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import todolist.dto.UserRequestDto;
import todolist.dto.UserResDto;
import todolist.entity.Student;
import todolist.entity.User;
import todolist.error.ErrorCodes;
import todolist.error.ServiceRuntimeException;
import todolist.repository.StudentRepository;
import todolist.repository.UserRepository;

@Service
public class StudentService implements UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    ModelMapper modelMapper;

    @Transactional
    @CachePut(value = "user", key = "#result.userId")
    @Override
    public UserResDto createUser(UserRequestDto userRequestDto) {
        List<User> listExistEmail = userRepository.findByEmail(userRequestDto.getEmail());
        if (!CollectionUtils.isEmpty(listExistEmail)) {
            throw new ServiceRuntimeException(HttpStatus.NOT_FOUND, ErrorCodes.EMAIL_001,
                    String.format("The user with email adress #%s already exists.", userRequestDto.getEmail()));
        }

        Student student = new Student();
        modelMapper.map(userRequestDto, student);
        if (userRequestDto.getStudent() != null) {
            student.setYear(userRequestDto.getStudent().getYear());
        }
        studentRepository.save(student);
        return modelMapper.map(student, UserResDto.class);
    }
}
