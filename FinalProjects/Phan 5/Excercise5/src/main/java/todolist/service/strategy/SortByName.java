package todolist.service.strategy;

import java.util.Comparator;
import java.util.List;

import todolist.entity.Course;
import todolist.service.SortStrategy;

public class SortByName implements SortStrategy {

    @Override
    public void sort(List<Course> courses) {
        courses.sort(Comparator.comparing(Course::getCourseName));
    }

}
