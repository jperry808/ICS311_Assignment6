package model;

// Creates a HighlightedUser object
public class HighlightedUser {
    // Contains a User and the amount of matches with the search criteria
    public User user;
    public int matchCount;

    public HighlightedUser(User user, int matchCount) {
        this.user = user;
        this.matchCount = matchCount;
    }
}
