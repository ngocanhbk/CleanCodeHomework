package todolist;

public class Main {
    public static void main(String[] args) throws Exception {
        Post post = new Post(1, "title 1", "content 1", null, null);
        post.savePost();
    }
}
