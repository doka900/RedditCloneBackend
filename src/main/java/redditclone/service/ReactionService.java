package redditclone.service;

import redditclone.model.dto.ReactionDTO;
import redditclone.model.entity.Reaction;

public interface ReactionService {

	Integer getKarma(long post_id);

	Integer findUserKarma(long voter_id);

	Boolean hasReacted(ReactionDTO reactionDTO);

	Boolean changeReaction(ReactionDTO reactionDTO);

	Reaction createReaction(ReactionDTO reactionDTO);

	void deleteByPost(long post_id);

}
