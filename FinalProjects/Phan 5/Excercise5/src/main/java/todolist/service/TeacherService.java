package todolist.service;

import java.util.List;
import java.util.Objects;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import todolist.dto.UserRequestDto;
import todolist.dto.UserResDto;
import todolist.entity.Teacher;
import todolist.entity.User;
import todolist.error.ErrorCodes;
import todolist.error.ServiceRuntimeException;
import todolist.repository.TeacherRepository;
import todolist.repository.UserRepository;

@Service
public class TeacherService implements UserService{
    @Autowired
    UserRepository userRepository;

    @Autowired
    TeacherRepository teacherRepository;

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
        User user;
        if (Objects.isNull(userRequestDto.getUserId())) {
            user = new User();
        } else {
            user = userRepository.findById(userRequestDto.getUserId())
                    .orElseThrow(() -> new ServiceRuntimeException(HttpStatus.NOT_FOUND, ErrorCodes.USER_001,
                            String.format("User not found: #%s", userRequestDto.getUserId())));
        }
        modelMapper.map(userRequestDto, user);
        User savedUser = userRepository.save(user);
        if (userRequestDto.getTeacher() != null) {
            Teacher teacher = new Teacher();
            teacher.setUserId(savedUser.getUserId());
            teacher.setExperiences(userRequestDto.getTeacher().getExperiences());
            teacher.setPhone(userRequestDto.getTeacher().getPhone());

            teacherRepository.save(teacher);
        }
        return modelMapper.map(savedUser, UserResDto.class);
    }
}
