package redditclone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import redditclone.model.entity.Reaction;
@Repository
public interface ReactionRepository extends JpaRepository<Reaction, Long>{

}
