package mx.org.corresponsabilidadsocial.api.blog.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.google.cloud.Date;
import com.google.cloud.Timestamp;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import mx.org.corresponsabilidadsocial.api.blog.entities.Post;
import mx.org.corresponsabilidadsocial.api.blog.entities.Status;
import mx.org.corresponsabilidadsocial.api.blog.repositories.PostRepository;

@ExtendWith(MockitoExtension.class)
public class ServiceTest {

    @InjectMocks
    PostService service;

    @Mock
    PostRepository repo;

    @Test
    public void testFindAllPosts() {
        List<Post> list = new ArrayList<Post>();
        Post postOne = new Post("title", "img/image.jpg", "test text", Timestamp.now(), Status.PUBLISHED);
        Post postTwo = new Post("hi!", "img/otherimage.jpg", "test text 1", Timestamp.now(), Status.PUBLISHED);
        Post postThree = new Post("bye", "img/img2.jpg", "test text 2", Timestamp.now(), Status.PUBLISHED);

        list.add(postOne);
        list.add(postTwo);
        list.add(postThree);

        //when(repo.getPosts()).thenReturn(list);

        //List<Post> postList = service.getPosts();

        //assertEquals(3, postList.size());
        //verify(repo, times(1)).getPosts();
    }

}