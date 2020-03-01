package pl.dominik.nauka.service;

import pl.dominik.nauka.model.Post;

public interface TopicService {
    void addTopicName(String topicName);
    void addPost(Post post);
}
