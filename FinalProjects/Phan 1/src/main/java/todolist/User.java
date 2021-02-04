package todolist;

import org.springframework.util.CollectionUtils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private long id;
    private String fullName;
    private ArrayList<Post> posts;
    private ArrayList<Comment> comments;

    public void writePosts() {
        if (!CollectionUtils.isEmpty(this.posts)) {
            this.posts.forEach(post -> post.save());
        }
    }

    public void deletePosts() {
        if (!CollectionUtils.isEmpty(this.posts)) {
            this.posts.forEach(post -> post.delete());
        }
    }

    public void writeComments() {
        if (!CollectionUtils.isEmpty(this.comments)) {
            this.comments.forEach(comment -> comment.save());
        }
    }

    public void deleteComments() throws IllegalAccessException {
        if (!CollectionUtils.isEmpty(this.comments)) {
            for (Comment comment : this.comments) {
                deleteComment(comment);
            }
        }
    }

    private void deleteComment(Comment comment) throws IllegalAccessException {
        if (this.id != comment.getAuthor().id) {
            throw new IllegalAccessException(
                    String.format("Can not delete other user comment. Other user id: %s", comment.getAuthor().id));
        } else {
            comment.delete();
        }
    }
}
