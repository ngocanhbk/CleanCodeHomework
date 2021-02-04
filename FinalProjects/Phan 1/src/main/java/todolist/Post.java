package todolist;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post {

    private long id;
    private String title;
    private String content;
    private User author;
    private ArrayList<Comment> comments;

    public void save() {
        savePost();
        saveComments();
    }
    public void savePost() {
        System.out.println(String.format("Save post %s successful.", this.title));
    }
    public void saveComments() {
        if(!CollectionUtils.isEmpty(this.comments)) {
            this.comments.forEach(comment -> comment.save());
            System.out.println("Save comments of post successful.");
        } else {
            System.out.println("This post has not comments to save.");
        }
    }

    public void delete() {
        deleteComments();
        deletePost();
    }
    public void deletePost() {
        System.out.println(String.format("Delete post %s successful.", this.title));
    }
    public void deleteComments() {
        if(!CollectionUtils.isEmpty(this.comments)) {
            this.comments.forEach(comment -> comment.delete());
            System.out.println("Delete comments of post successful.");
        } else {
            System.out.println("This post has not comments to delete.");
        }
    }
}
