package model;

import java.util.*;


// Creates a User object
public class User {
    // Contains all attributes the user created their account with and any posts they've made
    public String username;
    public Map<String, String> attributes = new HashMap<>();
    public List<Post> postsAuthored = new ArrayList<>();

    public User(String username) {
        this.username = username;
    }
}
