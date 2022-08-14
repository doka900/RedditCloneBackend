package redditclone.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import redditclone.model.dto.CreateUserDTO;
import redditclone.model.entity.User;

public interface UserService {

	public List<User> findAllUsers();

	public User createUser(CreateUserDTO userDTO);

	public User findUserById(long id);

	User findByUsername(String username);

}
