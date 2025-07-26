# ICS311_Assignment6

This Java program reads data from a social media network and visualizes it as a directed graph using the DOT format. Each user and post is represented as a node, with arrows showing authorship and viewership. "Interesting" users are color-coded based on how many criteria they match, in the preset example "interesting" criteria are posts authored, gender set as male, and located in Japan.

# How to Run

1. Simply clone the repository via GitHub Desktop

2. Compile the program (make sure you are in the project root folder)
```cmd
javac -d out src\model\User.java src\model\Post.java src\model\HighlightedUser.java src\visualization\GraphExporter.java src\visualization\SocialMediaAnalyzer.java
```
3. Run the program
```cmd
java -cp out visualization.SocialMediaAnalyzer
```
4. Now the social_graph.dot file will be populated, simply copy the code and paste into Graphviz via https://dreampuf.github.io/GraphvizOnline/
