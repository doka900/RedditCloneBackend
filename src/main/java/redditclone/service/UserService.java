package redditclone.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import redditclone.model.dto.CreateUserDTO;
import redditclone.model.dto.UpdateUserDTO;
import redditclone.model.entity.User;

public interface UserService {

	public List<User> findAllUsers();

	public User createUser(CreateUserDTO userDTO);

	public User findUserById(long id);

	public User findByUsername(String username);

	public User changePassword(String newPassword, String username);

	public Boolean oldPasswordVerification(String oldPassword, String username);

	public User updateUser(UpdateUserDTO updateUserDTO, String username);

	public User findUserByUsername(String username);
}
