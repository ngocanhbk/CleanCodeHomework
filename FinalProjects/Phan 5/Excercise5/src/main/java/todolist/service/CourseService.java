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
import todolist.dto.CourseSubtype2Dto;
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

        List<CourseSubtype2Dto> courses;
        if (keyword != null && !"".equals(keyword)) {
            courses = courseRepository.findByCourseNameLike(keyword);
        } else {
            courses = courseRepository.findAllCourse();
        }
        if (orderBy != null) {
            SortStrategy sortingStrategy = lookupSortingStrategy(orderBy);
            sortingStrategy.sort(courses);
        }

        List<CourseResDto> listCourse = new ArrayList<>();
        if (!CollectionUtils.isEmpty(courses)) {
            courses.forEach(item -> {
                CourseResDto course = new CourseResDto();
                course.setId(item.getId());
                course.setName(item.getName());
                course.setLocation(item.getLocation());
                course.setTeacherName(item.getTeacherName());
                listCourse.add(course);
            });
        }
        return listCourse;

    }
}
