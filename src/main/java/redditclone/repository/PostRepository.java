package redditclone.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import redditclone.model.entity.Post;

public interface PostRepository extends JpaRepository<Post, Long>{

}
