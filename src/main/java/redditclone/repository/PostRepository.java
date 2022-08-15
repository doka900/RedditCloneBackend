package redditclone.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import redditclone.model.entity.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

	@Modifying
	@Transactional
	@Query(value = "DELETE from posts p where p.title = ?1", nativeQuery = true)
	void deleteByTitle(String title);

	@Query(value = "select * from posts p where p.community_id = ?1", nativeQuery = true)
	public List<Post> findPostsByCommunityID(long community_id);

	@Query(value = "select * from posts p where p.author_id = ?1", nativeQuery = true)
	List<Post> getPostsByUser(long user_id);

	@Query(value = "select * from posts p where p.title = ?1", nativeQuery = true)
	public Post findByTitle(String title);

}
