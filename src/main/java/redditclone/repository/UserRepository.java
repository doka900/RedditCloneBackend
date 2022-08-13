package redditclone.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import redditclone.model.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
