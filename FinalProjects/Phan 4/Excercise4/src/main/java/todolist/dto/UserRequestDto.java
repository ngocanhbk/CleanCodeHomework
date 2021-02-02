package todolist.dto;

import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UserRequestDto {
    @ApiModelProperty(value = "User ID", example = "1")
    private Integer userId;

    @NotBlank
    @ApiModelProperty(value = "User name", example = "XYZ")
    private String userName;

    @NotBlank
    @ApiModelProperty(value = "User email", example = "xyz@gmail.com")
    private String email;

    @NotBlank
    @ApiModelProperty(value = "User password", example = "123456")
    private String password;

    @ApiModelProperty(value = "Mode", example = "TEACHER or STUDENT" )
    private String mode;

    @ApiModelProperty(value = "Student")
    private StudentDto student;

    @ApiModelProperty(value = "Teacher")
    private TeacherDto teacher;

}
