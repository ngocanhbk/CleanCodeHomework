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
@Table(name = "student")
@PrimaryKeyJoinColumn(name = "studentId")
public class Student extends User {

    private Integer year;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "student")
    private Set<Enroll> enrolls = new HashSet<>();

}
