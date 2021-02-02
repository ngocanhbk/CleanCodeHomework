package todolist.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class TeacherDto {

    @ApiModelProperty(value = "phone", example = "0123456789")
    private String phone;

    @ApiModelProperty(value = "experiences", example = "5")
    private Integer experiences;

}
