package todolist.service.strategy;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import todolist.entity.Course;
import todolist.service.SortStrategy;

public class SortByOpened implements SortStrategy {

    @Override
    public void sort(List<Course> courses) {
        Collections.sort(courses, Comparator.comparing(Course::getOpened).reversed());
    }

}
