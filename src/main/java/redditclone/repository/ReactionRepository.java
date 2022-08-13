package redditclone.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import redditclone.model.entity.Reaction;

public interface ReactionRepository extends JpaRepository<Reaction, Long>{

}
