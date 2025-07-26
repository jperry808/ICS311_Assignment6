package visualization;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import model.*;

public class GraphExporter {

    public static void exportToDotWithColors(List<User> users, Map<String, Post> posts, String filename) {
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write("digraph SocialGraph {\n");

            for (User user : users) {
                int matchCount = calculateInterest(user);

                // Determine the color based on the amount of matches or "score"
                String color;
                if (matchCount >= 3) {
                    color = "orchid"; 
                } else if (matchCount == 2) {
                    color = "mediumseagreen"; 
                } else if (matchCount == 1) {
                    color = "lightgoldenrod";
                } else {
                    color = "lightskyblue";
                }

                // Populate the node colors for the graph
                writer.write(String.format("  \"%s\" [shape=circle, style=filled, fillcolor=%s];\n", user.username, color));
            }
            
            // Populate the posts and users from the SocialMediaAnalyzer file
            int i = 0;
            for (Post post : posts.values()) {
                String postId = "post_" + i++;
                writer.write(String.format("  \"%s\" [label=\"Post\", shape=box, style=filled, fillcolor=lightcoral];\n", postId));
                writer.write(String.format("  \"%s\" -> \"%s\";\n", post.author.username, postId));

                for (User viewer : post.viewers) {
                    writer.write(String.format("  \"%s\" -> \"%s\" [style=dashed];\n", viewer.username, postId));
                }
            }

            writer.write("}\n");
            System.out.println("Graph with highlights exported to " + filename);
        } catch (IOException e) {
            System.err.println("Error writing .dot file: " + e.getMessage());
        }
    }

    // Logic to determine what is interesting (in this case located in Japan, male and having a post is "interesting")
    private static int calculateInterest(User user) {
        int count = 0;
        if ("male".equalsIgnoreCase(user.attributes.get("gender"))) count++;
        if ("Japan".equalsIgnoreCase(user.attributes.get("location"))) count++;
        if (user.postsAuthored.size() > 0) count++;
        return count;
    }
}
