package todolist.service;

import todolist.dto.UserRequestDto;
import todolist.dto.UserResDto;

public interface UserService {
    public UserResDto createUser(UserRequestDto userRequestDto);
}
