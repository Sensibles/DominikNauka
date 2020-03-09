package pl.dominik.nauka.service;

import pl.dominik.nauka.model.Post;
import pl.dominik.nauka.model.PostImpl;

import java.util.ArrayList;
import java.util.List;

public class TopicServiceImpl implements TopicService{

    String topicName;
    List<Post> posts = new ArrayList<>();

    @Override
    public void addTopicName(String topicName) {
        this.topicName = topicName;
    }

    @Override
    public void addPost(Post post) {
        posts.add(post);
    }

    @Override
    public List<Post> getPosts() {
        return posts;
    }

    @Override
    public Post getPostOfAuthor(String author) {
        for (int i=0; i < posts.size(); i++)
        {
            if (posts.get(i).getAuthor().equals(author));
            return posts.get(i);
        }
        return null;
        
    }

    @Override
    public int getSumOfAllLikes() {
        return 0;
    }

    //Robiles to juz uzywajac list.sort() i compareTo. Teraz zrob to uzywajac zwyklej petli for / foreach :)
    @Override
    public Post getMostLikedPost() {
        return null;
    }


}
