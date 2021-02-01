package todolist.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class StudentDto {

    @ApiModelProperty(value = "year", example = "2020")
    private String year;

}
