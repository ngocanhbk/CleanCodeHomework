package todolist.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseSubtype2Dto {

    private Integer id;

    private String name;

    private String location;

    private String description;

    private Date opened;

    private Integer teacherId;

    private String teacherName;

}
