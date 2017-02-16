package pl.denisolek;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.denisolek.model.Post;
import pl.denisolek.model.User;
import pl.denisolek.repository.PostRepository;
import pl.denisolek.repository.UserRepository;


@SpringBootApplication
public class BlogExampleApplication {

	private static UserRepository userRepository;
	private static PostRepository postRepository;

	@Autowired
	public BlogExampleApplication(UserRepository userRepository, PostRepository postRepository) {
		this.userRepository = userRepository;
		this.postRepository = postRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(BlogExampleApplication.class, args);
		
		databaseSeed();
	}
	
	private static void databaseSeed() {
		User user1 = new User("User1", "password1", "User One");
		User user2 = new User("User2", "password2", "User Two");
		User user3 = new User("User3", "password3", "User Three");

		Post post1 = new Post("Title1", "Body1", user1);
		Post post2 = new Post("Title2", "Body2", user1);
		Post post3 = new Post("Title3", "Body3", user1);
		Post post4 = new Post("Title4", "Body4", user3);
		Post post5 = new Post("Title5", "Body5", user2);
		Post post6 = new Post("Title6", "Body6", user2);

		userRepository.save(user1);
		userRepository.save(user2);
		userRepository.save(user3);

		postRepository.save(post1);
		postRepository.save(post2);
		postRepository.save(post3);
		postRepository.save(post4);
		postRepository.save(post5);
		postRepository.save(post6);
	}
}
