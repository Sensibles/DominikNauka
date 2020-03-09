package pl.dominik.nauka.service;

import pl.dominik.nauka.model.Post;

import java.util.List;

public interface TopicService {
    void addTopicName(String topicName);
    void addPost(Post post);
    List<Post> getPosts();
    Post getPostOfAuthor(String author);
}
