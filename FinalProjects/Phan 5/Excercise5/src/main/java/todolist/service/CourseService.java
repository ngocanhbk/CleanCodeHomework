package todolist.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import todolist.dto.CourseResDto;
import todolist.entity.Course;
import todolist.repository.CourseRepository;
import todolist.service.strategy.SortByName;
import todolist.service.strategy.SortByOpened;

@Service
public class CourseService {
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    CourseRepository courseRepository;
    private static Map<String, SortStrategy> strategies;

    static {
        strategies = new HashMap<>();
        strategies.put("name", new SortByName());
        strategies.put("opened", new SortByOpened());
    }

    private SortStrategy lookupSortingStrategy(String strategyName) {
        SortStrategy sortingStrategy = strategies.get(strategyName);
        if (sortingStrategy == null) {
            throw new UnsupportedOperationException("Unsupported sorting strategy");
        }
        return sortingStrategy;
    }

    @Transactional(readOnly = true)
    // @CachePut(value = "course", key = "#result.id")
    public List<CourseResDto> getCourses(String keyword, String orderBy) {

        List<Course> courses;
        if (keyword != null && !"".equals(keyword)) {
            courses = courseRepository.findByCourseNameContainingIgnoreCase(keyword);
        } else {
            courses = courseRepository.findAll();
        }
        if (orderBy != null) {
            SortStrategy sortingStrategy = lookupSortingStrategy(orderBy);
            sortingStrategy.sort(courses);
        }
        List<CourseResDto> listCourse = new ArrayList<>();
        if (!CollectionUtils.isEmpty(courses)) {
            courses.forEach(item -> {
                CourseResDto course = new CourseResDto();
                course.setId(item.getCourseId());
                course.setName(item.getCourseName());
                course.setLocation(item.getLocation());
                course.setTeacherName(item.getTeacher().getUserName());
                listCourse.add(course);
            });
        }
        return listCourse;

    }
}
