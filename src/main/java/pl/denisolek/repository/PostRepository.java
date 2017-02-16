package pl.denisolek.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.denisolek.model.Post;

public interface PostRepository extends JpaRepository<Post, Long>{
}
