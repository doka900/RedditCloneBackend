package redditclone.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import redditclone.repository.PostRepository;
import redditclone.service.PostService;
@Service
public class PostServiceImplementaion implements PostService{

	@Autowired
	private PostRepository postRepository;
}
