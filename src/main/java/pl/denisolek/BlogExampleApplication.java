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

	public static void main(String[] args) { SpringApplication.run(BlogExampleApplication.class, args); }
}
