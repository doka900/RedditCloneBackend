package redditclone.service.implementation;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import redditclone.model.dto.PostDTO;
import redditclone.model.dto.ReactionDTO;
import redditclone.model.entity.Community;
import redditclone.model.entity.Post;
import redditclone.model.entity.ReactionType;
import redditclone.repository.CommunityRepository;
import redditclone.repository.PostRepository;
import redditclone.repository.ReactionRepository;
import redditclone.repository.UserRepository;
import redditclone.service.PostService;
import redditclone.service.ReactionService;

@Service
public class PostServiceImplementaion implements PostService {

	@Autowired
	private PostRepository postRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private CommunityRepository communityRepository;

	@Autowired
	ReactionService reactionService;

	public List<PostDTO> findAllPosts() {
		List<PostDTO> allPosts = new ArrayList<>();
		for (Post p : postRepository.findAll()) {
			PostDTO post = new PostDTO();
			post.setId(p.getId());
			post.setText(p.getText());
			post.setTitle(p.getTitle());
			post.setCommunity_name(communityRepository.findCommunityById(p.getCommunity().getId()).getName());
			post.setAuthor_name(userRepository.findUserById(p.getAuthor().getId()).getUsername());
			allPosts.add(post);
		}
		return allPosts;
	}

	public List<PostDTO> findPostsOfCommunity(String name) {

		List<PostDTO> posts = new ArrayList<>();
		for (Post p : postRepository.findPostsByCommunityID((communityRepository.findByName(name)).getId())) {
			PostDTO post = new PostDTO();
			post.setId(p.getId());
			post.setText(p.getText());
			post.setTitle(p.getTitle());
			post.setCommunity_name(communityRepository.findCommunityById(p.getCommunity().getId()).getName());
			post.setAuthor_name(userRepository.findUserById(p.getAuthor().getId()).getUsername());
			posts.add(post);
		}

		return posts;
	}

	public Post createPost(PostDTO postDTO) {

		Post newPost = new Post();

		newPost.setTitle(postDTO.getTitle());
		newPost.setText(postDTO.getText());

		newPost.setCommunity(communityRepository.findByName((postDTO.getCommunity_name())));
		newPost.setAuthor(userRepository.findByUsername(postDTO.getAuthor_name()));

		postRepository.save(newPost);

		ReactionDTO reaction = new ReactionDTO();
		reaction.setPost_id(newPost.getId());
		reaction.setVoter_id(newPost.getAuthor().getId());
		reaction.setType(ReactionType.UPVOTE);

		reactionService.createReaction(reaction);

		return newPost;
	}

	@Override
	public void deleteByTitle(String title) {
		Post post = postRepository.findByTitle(title);
		postRepository.deleteByTitle(title);
		reactionService.deleteByPost(post.getId());

	}

}
