package todolist.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import todolist.dto.CourseSubtype2Dto;
import todolist.entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {
    @Query("select new todolist.dto.CourseSubtype2Dto ("
            + "c.courseId as id, "
            + "c.courseName as name,"
            + "c.location,"
            + "c.description,"
            + "c.opened,"
            + "c.teacherId,"
            + "u.userName as teacherName "
            + ") from "
            + "Course c "
            + "inner join Teacher teacher on c.teacherId = teacher.teacherId "
            + "inner join User u on u.userId = teacher.userId "
            + "where c.courseName like %:keyword% ")
    List<CourseSubtype2Dto> findByCourseNameLike(@Param("keyword") String keyword);
    @Query("select new todolist.dto.CourseSubtype2Dto ("
            + "c.courseId as id, "
            + "c.courseName as name,"
            + "c.location,"
            + "c.description,"
            + "c.opened,"
            + "c.teacherId,"
            + "u.userName as teacherName "
            + ") from "
            + "Course c "
            + "inner join Teacher teacher on c.teacherId = teacher.teacherId "
            + "inner join User u on u.userId = teacher.userId")
    List<CourseSubtype2Dto> findAllCourse();

}
