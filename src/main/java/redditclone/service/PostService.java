package redditclone.service;

import java.util.List;

import redditclone.model.dto.PostDTO;
import redditclone.model.entity.Post;

public interface PostService {

	public List<PostDTO> findAllPosts();

	public List<PostDTO> findPostsOfCommunity(String name);

	public Post createPost(PostDTO postDTO);

	public void deleteByTitle(String title);

}
