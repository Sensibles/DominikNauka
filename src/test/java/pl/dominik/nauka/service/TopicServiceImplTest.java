package pl.dominik.nauka.service;

import org.junit.jupiter.api.Test;
import pl.dominik.nauka.model.Post;
import pl.dominik.nauka.model.PostImpl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class TopicServiceImplTest {

    @Test
    void shouldAddPostToTopic() {
        TopicService topicService = new TopicServiceImpl();
        topicService.addTopicName("Problemy wspolczenych mezczyzn.");
        Post post = new PostImpl();
        post.setAuthor("Patrycja");
        post.setText("Programisci to pizdy, hehehehe");
        topicService.addPost(post);

        assertThat(topicService.getPosts()).hasSize(1).contains(post);
    }


    @Test
    void shouldFindTopicOfAuthor() {
        TopicService topicService = new TopicServiceImpl();
        topicService.addTopicName("Problemy wspolczenych mezczyzn.");
        Post post = new PostImpl();
        post.setAuthor("Patrycja");
        post.setText("Programisci to pizdy, hehehehe");
        topicService.addPost(post);
        Post post2 = new PostImpl();
        post2.setAuthor("Artur");
        post2.setText("Kiedys widzialem cycki");
        topicService.addPost(post2);
        assertThat(topicService.getPostOfAuthor("Patrycja")).isEqualTo(post);
    }

    @Test
    void shouldSumLikesFromAllPosts() {
        TopicService topicService = new TopicServiceImpl();
        topicService.addTopicName("Problemy wspolczenych mezczyzn.");

        Post post = new PostImpl();
        post.setAuthor("Patrycja");
        post.setText("Programisci to pizdy, hehehehe");
        post.addLike("Artur");
        post.addLike("Dominik");
        post.addLike("Kozuh");
        post.addLike("Brat kozuha #11");
        topicService.addPost(post);

        Post post2 = new PostImpl();
        post2.setAuthor("Artur");
        post2.setText("Kiedys widzialem cycki");
        post2.addLike("Artur");
        topicService.addPost(post2);

        Post post3 = new PostImpl();
        post3.setAuthor("Dominik");
        post3.setText("Bende koderem");
        post3.addLike("Obecny pracodawca Dominika");
        topicService.addPost(post3);

        assertThat(topicService.getSumOfAllLikes()).isEqualTo(6);
    }

    @Test
    void shouldGetMostLikedPost() {
        TopicService topicService = new TopicServiceImpl();
        topicService.addTopicName("Problemy wspolczenych mezczyzn.");

        Post post = new PostImpl();
        post.setAuthor("Patrycja");
        post.setText("Programisci to pizdy, hehehehe");
        post.addLike("Artur");
        post.addLike("Dominik");
        post.addLike("Kozuh");
        post.addLike("Brat kozuha #11");
        topicService.addPost(post);

        Post post2 = new PostImpl();
        post2.setAuthor("Artur");
        post2.setText("Kiedys widzialem cycki");
        post2.addLike("Artur");
        topicService.addPost(post2);

        Post post3 = new PostImpl();
        post3.setAuthor("Dominik");
        post3.setText("Bende koderem");
        post3.addLike("Obecny pracodawca Dominika");
        topicService.addPost(post3);

        assertThat(topicService.getMostLikedPost().countLikes()).isEqualTo(4);
    }

}