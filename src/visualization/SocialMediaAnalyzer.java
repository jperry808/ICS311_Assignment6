package visualization;

import java.util.*;
import model.*;

public class SocialMediaAnalyzer {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        Map<String, Post> posts = new LinkedHashMap<>();

        // Create users with attribute data
        User alice = new User("alice");
        alice.attributes.put("gender", "female");
        alice.attributes.put("location", "Hawaii");

        User bob = new User("bob");
        bob.attributes.put("gender", "male");
        bob.attributes.put("location", "Japan");

        User charlie = new User("charlie");
        charlie.attributes.put("gender", "male");
        charlie.attributes.put("location", "Korea");

        User dana = new User("dana");
        dana.attributes.put("gender", "female");
        dana.attributes.put("location", "USA");

        User elena = new User("elena");
        elena.attributes.put("gender", "female");
        elena.attributes.put("location", "Japan");

        User frank = new User("frank");
        frank.attributes.put("gender", "male");
        frank.attributes.put("location", "Canada");

        User grace = new User("grace");
        grace.attributes.put("gender", "female");
        grace.attributes.put("location", "UK");

        // Add all users to list
        users.addAll(Arrays.asList(alice, bob, charlie, dana, elena, frank, grace));

        // Create test posts
        Post p1 = new Post("Test post 1", alice);
        Post p2 = new Post("Test post 2", bob);
        Post p3 = new Post("Test post 3", charlie);
        Post p4 = new Post("Test post 4", elena);

        // Assign post viewers
        p1.viewers.addAll(List.of(bob, charlie));
        p2.viewers.addAll(List.of(alice, dana));
        p3.viewers.addAll(List.of(frank, grace));
        p4.viewers.addAll(List.of(alice, bob, dana));

        // Assign post author/creators
        alice.postsAuthored.add(p1);
        bob.postsAuthored.add(p2);
        charlie.postsAuthored.add(p3);
        elena.postsAuthored.add(p4);

        // Add posts to map
        posts.put("p1", p1);
        posts.put("p2", p2);
        posts.put("p3", p3);
        posts.put("p4", p4);

        // Export graph with colored highlights
        GraphExporter.exportToDotWithColors(users, posts, "social_graph.dot");
    }
}
