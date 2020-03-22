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
        int sumOfLikes = 0;
        for (int i=0; i<posts.size(); i++)
        {
            sumOfLikes += posts.get(i).countLikes();


        }
        return sumOfLikes;
    }

    //Robiles to juz uzywajac list.sort() i compareTo. Teraz zrob to uzywajac zwyklej petli for / foreach :)
    @Override
    public Post getMostLikedPost() {
        Post max = posts.get(0);
        for (Post x : posts)
        {
            if (x.countLikes() > max.countLikes())
                max = x;
        }
        return max;
    }

    @Override
    public List<Post> bubbleSortPostsByLikes() {
        //todo uzyj buuble sort
        return null;
    }

    @Override
    public List<Post> quickSortPostsByLikes() {
        //todo uzyj quick sort
        return null;
    }
}
