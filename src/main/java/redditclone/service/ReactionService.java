package redditclone.service;

import redditclone.model.dto.ReactionDTO;
import redditclone.model.entity.Reaction;

public interface ReactionService {

	public Integer getKarma(long post_id);

	public Integer findUserKarma(long voter_id);

	public Boolean hasReacted(ReactionDTO reactionDTO);

	public Boolean changeReaction(ReactionDTO reactionDTO);

	public Reaction createReaction(ReactionDTO reactionDTO);

	public void deleteByPost(long post_id);

}
