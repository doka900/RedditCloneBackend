package redditclone.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import redditclone.model.entity.Reaction;
@Repository
public interface ReactionRepository extends JpaRepository<Reaction, Long>{

    @Query (value = "select * from reaction v where v.post_id = ?1 and v.reaction_type like 'UPVOTE'", nativeQuery = true)
	List<Reaction> findPostUpvotes(long post_id);

    
    @Query (value = "select * from reaction v where v.post_id = ?1 and v.reaction_type like 'DOWNVOTE'", nativeQuery = true)
	List<Reaction> findPostDownvotes(long post_id);


	@Query(value = "SELECT * from reaction v where v.post_id = ?1 and v.voter_id = ?2", nativeQuery = true)
    List<Reaction> hasReacted(long post_id, long voter_id);


	@Modifying
	@Transactional
	@Query(value = "update reaction v set v.reaction_type = ?1 where v.post_id = ?2 and v.voter_id = ?3", nativeQuery = true)
	void changeReaction(String string, long post_id, long voter_id);


	@Query(value = "SELECT * from reaction v where v.post_id = ?1 and v.voter_id = ?2", nativeQuery = true)
    Reaction React(long post_id, long voter_id);
	
	@Modifying
    @Transactional
    @Query (value = "DELETE from reaction where post_id = ?1", nativeQuery = true)
	void deleteByPost_id(long post_id);
}
