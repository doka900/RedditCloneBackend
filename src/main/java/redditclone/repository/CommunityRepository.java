package redditclone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import redditclone.model.dto.CommunityDTO;
import redditclone.model.entity.Community;

@Repository
public interface CommunityRepository extends JpaRepository<Community, Long>{

	Community findByName(String name);
	
	@Modifying
	@Transactional
	@Query(value = "update communities c set c.name = ?1, c.description = ?2 where c.community_id=?3 ", nativeQuery = true)
    void updateCommunity(String name, String description, long id );

	Community findCommunityById(Long id);
	
}
