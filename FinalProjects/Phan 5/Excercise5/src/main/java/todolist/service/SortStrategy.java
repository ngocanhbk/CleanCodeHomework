package todolist.service;

import java.util.List;

import todolist.entity.Course;

public interface SortStrategy {
    void sort(List<Course> courses);
}
