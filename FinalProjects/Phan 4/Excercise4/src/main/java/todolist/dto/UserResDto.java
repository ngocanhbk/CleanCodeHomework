package todolist.dto;

import javax.validation.constraints.NotBlank;

import org.springframework.hateoas.RepresentationModel;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Response DTO
 */
@Data
public class UserResDto extends RepresentationModel<UserResDto> {

    @NotBlank
    @ApiModelProperty(value = "User name", example = "XYZ")
    private String userId;
    
    @NotBlank
    @ApiModelProperty(value = "User name", example = "XYZ")
    private String userName;

    @ApiModelProperty(value = "Email", example = "xyz@gmail.com")
    private String email;

}
