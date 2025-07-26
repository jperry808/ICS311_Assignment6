package model;

import java.util.*;

// Creates a Post object
public class Post {
    // String for text in the post, User for the post's author and an array list of all viewers
    public String content;
    public User author;
    public List<User> viewers = new ArrayList<>();

    public Post(String content, User author) {
        this.content = content;
        this.author = author;
    }
}
