package todolist;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment {

    private long id;
    private String title;
    private Post post;
    private User author;

    public void save() {
        System.out.println(String.format("Save comment %s successful.", this.title));
    }
    public void delete() {
        System.out.println(String.format("Delete comment %s successful.", this.title));
    }
}
