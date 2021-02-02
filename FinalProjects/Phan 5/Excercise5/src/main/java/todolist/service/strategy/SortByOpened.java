package todolist.service.strategy;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import todolist.dto.CourseSubtype2Dto;
import todolist.service.SortStrategy;

public class SortByOpened implements SortStrategy {

    @Override
    public void sort(List<CourseSubtype2Dto> courses) {
//        courses.sort(Comparator.comparing(CourseSubtype2Dto::getOpened));
        Collections.sort(courses, Comparator.comparing(CourseSubtype2Dto::getOpened).reversed());
    }

}
