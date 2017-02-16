package pl.denisolek.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.denisolek.model.Post;
import pl.denisolek.model.User;
import pl.denisolek.model.request.AddPostRequest;
import pl.denisolek.repository.PostRepository;
import pl.denisolek.repository.UserRepository;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController("posts")
public class PostController {
    private PostRepository postRepository;
    private UserRepository userRepository;

    @Autowired
    public PostController(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    @RequestMapping(value = "/api/posts", method = RequestMethod.GET)
    public List<Post> findAllPosts() {
        return postRepository.findAll();
    }

    @RequestMapping(value = "/api/posts", method = RequestMethod.POST, headers = "Accept=application/json")
    public void addUser(@RequestBody AddPostRequest addPostRequest, HttpServletResponse response) {
        Post post = new Post();

        User user = userRepository.findOne(addPostRequest.getUser_id());
        post.setTitle(addPostRequest.getTitle());
        post.setBody(addPostRequest.getBody());
        post.setUser(user);

        postRepository.save(post);
    }
}
