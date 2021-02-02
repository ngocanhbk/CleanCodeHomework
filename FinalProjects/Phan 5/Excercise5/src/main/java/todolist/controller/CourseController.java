package todolist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import todolist.dto.CourseResDto;
import todolist.service.CourseService;

@RestController
@RequiredArgsConstructor
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping("/api/v1/courses")
    @ApiOperation("Get course by course name")
    @ApiResponses({ @ApiResponse(code = 200, message = "Get course successfully"),
            @ApiResponse(code = 404, message = "Course not found") })
    public ResponseEntity<CollectionModel<CourseResDto>> getCourses(
            @ApiParam(value = "Course name", example = "course 1") @RequestParam(value = "keyword") String keyword,
            @ApiParam(value = "Order by", example = "name is ASC, opened is DESC ") @RequestParam(value = "orderBy") String orderBy) {
        CollectionModel<CourseResDto> response = CollectionModel.of(courseService.getCourses(keyword, orderBy));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
