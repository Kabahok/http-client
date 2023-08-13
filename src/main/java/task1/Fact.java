package task1;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Fact {
    private String id;
    private String text;
    private String user;
    private String type;
    private int upvotes;

    public Fact(
            @JsonProperty("id") String id,
            @JsonProperty("text") String text,
            @JsonProperty("user") String user,
            @JsonProperty("type") String type,
            @JsonProperty("upvotes") int upvotes
    ) {
        this.id = id;
        this.text = text;
        this.user = user;
        this.type = type;
        this.upvotes = upvotes;

    }

    public int getUpvotes() {
        return upvotes;
    }


    @Override
    public String toString() {
        return String.format("%s\n%s\n%s\n%s\n%d\n", id, text, type, user, upvotes);
    }

}
