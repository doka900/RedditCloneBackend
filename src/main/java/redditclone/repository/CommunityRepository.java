package redditclone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import redditclone.model.entity.Community;

@Repository
public interface CommunityRepository extends JpaRepository<Community, Long>{

}
