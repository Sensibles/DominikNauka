package pl.dominik.nauka.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class PostTest {

    @Test
    void shouldDisplayPost() {
        Post post = new PostImpl();
        post.setAuthor("Tomasz");
        post.setText("Gdzie dostane dwusznuran samobójacznu?");

        assertThat(post.displayPost()).isEqualTo("Tomasz: Gdzie dostane dwusznuran samobójacznu?");
    }

    @Test
    void shouldReplaceOldTextWithNewOne() {
        Post post = new PostImpl();
        post.setAuthor("Tomasz");
        post.setText("Gdzie dostane dwusznuran samobójacznu?");
        post.setText("Jestem szczesliwym czlowiekiem... :)");

        assertThat(post.displayPost()).isEqualTo("Tomasz: Jestem szczesliwym czlowiekiem... :)");
    }

    @Test
    void shouldAddLikesAndDisplayCount() {
        Post post = new PostImpl();
        post.addLike("Artur");
        post.addLike("Dominik");

        assertThat(post.countLikes()).isEqualTo(2);
    }

    @Test
    void shouldAddLikesAndDisplayLikers() {
        Post post = new PostImpl();
        post.addLike("Artur");
        post.addLike("Dominik");

        assertThat(post.displayLikers()).hasSize(2).contains("Artur", "Dominik");
    }

    @Test
    void shouldDisplayArturAsFirstLikerAlphabetically() {
        Post post = new PostImpl();
        post.addLike("Artur");
        post.addLike("Dominik");
        post.addLike("Kożuh");

        assertThat(post.getFirstLikerAlphabetically()).isEqualTo("Artur");
    }

    @Test
    void shouldSortPostsByLikesCount() {
        Post postTomasz = new PostImpl();
        postTomasz.setAuthor("Tomasz");
        postTomasz.setText("Gdzie dostane dwusznuran samobójacznu?");
        postTomasz.addLike("Dominik");

        Post postDominik = new PostImpl();
        postDominik.setAuthor("Chujogrzmij");
        postDominik.setText("Stare kurwy jebać pradem");
        postDominik.addLike("Dominik");
        postDominik.addLike("Artur");
        postDominik.addLike("Tomasz");

        Post postArtur = new PostImpl();
        postArtur.setAuthor("Artur");
        postArtur.setText("Stare kurwy jebać pradem");
        postArtur.addLike("Dominik");
        postArtur.addLike("Artur");

        List<Post> posts = new ArrayList<>();
        posts.add(postArtur);
        posts.add(postDominik);
        posts.add(postTomasz);

        posts.sort(Post::compareTo);

        assertThat(posts.get(posts.size()-1).displayPost()).isEqualTo("Chujogrzmij: Stare kurwy jebać pradem");



    }
}