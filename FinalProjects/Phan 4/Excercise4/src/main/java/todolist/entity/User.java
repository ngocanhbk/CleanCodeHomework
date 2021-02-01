package todolist.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    private String userName;

    private String email;

    private String password;

//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user", orphanRemoval = true)
//    private List<Task> tasks = new ArrayList<>();
//
//    public void addTask(Task task) {
//        this.tasks.add(task);
//        task.setUser(this);
//    }
//
//    public void removeTask(Task task) {
//        task.setUser(null);
//        this.tasks.remove(task);
//    }
//
//    public void removeTasks() {
//        Iterator<Task> iterator = this.tasks.iterator();
//        while (iterator.hasNext()) {
//            Task task = iterator.next();
//            task.setUser(null);
//            iterator.remove();
//        }
//    }

}
