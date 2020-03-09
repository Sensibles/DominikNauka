package pl.dominik.nauka.model;

import java.util.List;


public interface Post extends Comparable<Post> {
    void setAuthor(String author);
    void setText(String text);
    String displayPost();
    void addLike(String user);
    int countLikes();
    List<String> displayLikers();
    String getFirstLikerAlphabetically();
    String getAuthor();
}
