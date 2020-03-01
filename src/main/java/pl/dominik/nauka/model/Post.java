package pl.dominik.nauka.model;

public interface Post {
    void addAuthor(String author);
    void addText(String text);
    String displayPost();
}
