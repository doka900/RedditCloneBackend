package redditclone.service.implementation;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import redditclone.model.dto.ReactionDTO;
import redditclone.model.entity.Post;
import redditclone.model.entity.Reaction;
import redditclone.model.entity.ReactionType;
import redditclone.repository.PostRepository;
import redditclone.repository.ReactionRepository;
import redditclone.service.ReactionService;
@Service
public class ReactionServiceImplementaion implements ReactionService{

	@Autowired
	private ReactionRepository reactionRepository;
	@Autowired
	private PostRepository postRepository;
	
	public Integer getKarma(long post_id) {
		return findPostUpvotes(post_id).size() - findPostDownvotes(post_id).size();
	}
	
	public List<Reaction> findPostUpvotes(long postId){
		return reactionRepository.findPostUpvotes(postId);
	}
	
	public List<Reaction> findPostDownvotes(long postId){
		return reactionRepository.findPostDownvotes(postId);
	}

	@Override
	public Integer findUserKarma(long user_id) {
		int karma = 0;
		List<Post> posts = postRepository.getPostsByUser(user_id);
		for(Post post: posts) {
				karma += getKarma(post.getId());
		}
		return karma;
	}

	@Override
	public Boolean hasReacted(ReactionDTO reactionDTO) {
		if(((List<Reaction>) reactionRepository.hasReacted(reactionDTO.getPost_id(), reactionDTO.getVoter_id())).isEmpty())return false;
		else return true;
	}

	@Override
	public Boolean changeReaction(ReactionDTO reactionDTO) {
		Reaction reaction = reactionRepository.React(reactionDTO.getPost_id(), reactionDTO.getVoter_id());
		
		if(reaction.getReaction_type() != reactionDTO.getType())
		{
		if(reactionDTO.getType().toString().equals("DOWNVOTE"))
		reactionRepository.changeReaction("DOWNVOTE", reactionDTO.getPost_id(), reactionDTO.getVoter_id()) ;
		
		else if(reactionDTO.getType().toString().equals("UPVOTE"))
		reactionRepository.changeReaction("UPVOTE", reactionDTO.getPost_id(), reactionDTO.getVoter_id()) ;
		}
		return true;
	}

	@Override
	public Reaction createReaction(ReactionDTO reactionDTO) {
		if(!hasReacted(reactionDTO))
		{
		Reaction reaction = new Reaction();
		reaction.setPost_id(reactionDTO.getPost_id());
		reaction.setVoter_id(reactionDTO.getVoter_id());
		reaction.setTime_stamp(LocalDate.now());
		if(reactionDTO.getType() == ReactionType.UPVOTE)
			reaction.setReaction_type(ReactionType.UPVOTE);
		if(reactionDTO.getType() == ReactionType.DOWNVOTE)
			reaction.setReaction_type(ReactionType.DOWNVOTE);
		
	    reactionRepository.save(reaction);
	    return reaction;
	    }
		else {
			changeReaction(reactionDTO);
			return null;
		}
	}
	
	@Override
	public void deleteByPost(long post_id) {
		reactionRepository.deleteByPost_id(post_id);
		
	}
}
