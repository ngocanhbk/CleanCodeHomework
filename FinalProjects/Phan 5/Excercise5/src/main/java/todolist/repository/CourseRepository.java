package todolist.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import todolist.entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {
    
    List<Course> findByCourseNameContainingIgnoreCase(String keyword);
}
