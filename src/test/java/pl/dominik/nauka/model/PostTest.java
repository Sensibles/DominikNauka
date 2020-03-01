package pl.dominik.nauka.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class PostTest {

    @Test
    void shouldDisplayPost() {
        Post post = new PostImpl();
        post.addAuthor("Tomasz");
        post.addText("Gdzie dostane dwusznuran samobójacznu?");

        assertThat(post.displayPost()).isEqualTo("Tomasz: Gdzie dostane dwusznuran samobójacznu?");
    }

    @Test
    void shouldReplaceOldTextWithNewOne() {
        Post post = new PostImpl();
        post.addAuthor("Tomasz");
        post.addText("Gdzie dostane dwusznuran samobójacznu?");
        post.addText("Jestem szczesliwym czlowiekiem... :)");

        assertThat(post.displayPost()).isEqualTo("Tomasz: Jestem szczesliwym czlowiekiem... :)");
    }

}