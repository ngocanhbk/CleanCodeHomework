package todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import todolist.entity.Teacher;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Integer> {

}
