package redditclone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import redditclone.service.ReactionService;

@CrossOrigin
@RestController
@RequestMapping("api/reaction")
public class ReactionController {

	@Autowired
	private ReactionService reactionService;
}
