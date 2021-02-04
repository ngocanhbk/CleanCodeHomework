package todolist.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "teacher")
@PrimaryKeyJoinColumn(name = "teacherId")
public class Teacher extends User {

    private String phone;

    private Integer experiences;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "teacher")
    private Set<Course> courses = new HashSet<>();

}
