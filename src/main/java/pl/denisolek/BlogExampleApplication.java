package pl.denisolek;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.denisolek.model.User;
import pl.denisolek.repository.UserRepository;

import java.util.Arrays;

@SpringBootApplication
public class BlogExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogExampleApplication.class, args);
	}

	@Bean
	CommandLineRunner init(UserRepository userRepository) {
		return (args) ->
				Arrays.asList("test1,test2,test3,test4".split(","))
				.forEach(
						a -> {
							userRepository.save(new User(a.toString(), a.toString()));
						}
				);
	}
}
