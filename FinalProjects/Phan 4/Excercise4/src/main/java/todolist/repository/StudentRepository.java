package todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import todolist.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

}
