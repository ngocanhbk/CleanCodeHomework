package todolist.service;

import java.util.List;

import todolist.dto.CourseSubtype2Dto;

public interface SortStrategy {
    void sort(List<CourseSubtype2Dto> courses);
}
