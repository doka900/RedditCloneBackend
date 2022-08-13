package redditclone.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import redditclone.model.entity.Community;

public interface CommunityRepository extends JpaRepository<Community, Long>{

}
