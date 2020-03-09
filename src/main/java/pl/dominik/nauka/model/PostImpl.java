package pl.dominik.nauka.model;

import java.util.ArrayList;
import java.util.List;

public class PostImpl implements Post {


    private String author, text;
    private List<String> likers = new ArrayList<>();

    @Override
    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String displayPost() {

        return author +": " + text;
    }

    @Override
    public void addLike(String user) {
        likers.add(user);
    }

    @Override
    public int countLikes() {
        return likers.size();
    }

    @Override
    public List<String> displayLikers() {
        return likers;
    }

    @Override
    public String getFirstLikerAlphabetically() {
        likers.sort(String::compareTo);
        return likers.get(0);

    }

    @Override
    public String getAuthor() {
        return this.author;
    }

    @Override
    public int compareTo(Post o) {
        int myLikes = this.countLikes();
        int likesFromOtherPosts = o.countLikes();
        if (myLikes < likesFromOtherPosts)
        {
            return -1;
        }
        else if (myLikes == likesFromOtherPosts)
        {
            return 0;
        }
        else
        {
            return 1;
        }
    }
}
