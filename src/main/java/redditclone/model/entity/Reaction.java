package redditclone.model.entity;

import java.time.LocalDate;



public class Reaction {

	private Long reaction_id;
	
	private ReactionType type;

	private LocalDate time_stamp;

	private long voter_id;

	private long post_id;
	
	
}
