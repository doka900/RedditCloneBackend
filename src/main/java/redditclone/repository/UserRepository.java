package redditclone.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import redditclone.model.entity.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	User findByUsername(String username);

	@Modifying
	@Transactional
	@Query(value = "update users u set u.password = ?1 where u.id=?2 ", nativeQuery = true)
	void changePassord(String password, Long id);

	
	@Modifying
	@Transactional
	@Query(value = "update users u set u.description = ?1, u.display_name = ?2 where u.id=?3 ", nativeQuery = true)
	void updateUser( String description, String display_name, long id);

	User findUserById(Long id);
}
