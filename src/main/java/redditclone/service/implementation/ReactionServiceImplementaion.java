package redditclone.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import redditclone.repository.ReactionRepository;
import redditclone.service.ReactionService;
@Service
public class ReactionServiceImplementaion implements ReactionService{

	@Autowired
	private ReactionRepository reactionRepository;
	
}
