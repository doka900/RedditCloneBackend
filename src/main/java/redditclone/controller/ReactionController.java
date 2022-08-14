package redditclone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import redditclone.model.dto.ReactionDTO;
import redditclone.model.entity.Reaction;
import redditclone.service.ReactionService;

@CrossOrigin
@RestController
@RequestMapping("api/reaction")
public class ReactionController {

	@Autowired
	private ReactionService reactionService;
	
    @GetMapping(value = "/{post_id}/")
    public ResponseEntity<Integer> findKarma(@PathVariable("post_id") long post_id){
        return new ResponseEntity<Integer>(reactionService.getKarma(post_id), HttpStatus.OK);
    }
    
    @GetMapping(value = "/voter/{voter_id}/")
    public ResponseEntity<Integer> findUserKarma(@PathVariable("voter_id") long voter_id){
        return new ResponseEntity<>(reactionService.findUserKarma(voter_id), HttpStatus.OK);
    }
    
    
    @GetMapping(value = "/",consumes = "application/json")
    public ResponseEntity<Boolean> hasReacted(@RequestBody ReactionDTO reactionDTO){
        return new ResponseEntity<Boolean>(reactionService.hasReacted(reactionDTO), HttpStatus.OK);
    }
    
    @PutMapping(value = "/",consumes = "application/json")
    public ResponseEntity<Boolean> changeReaction(@RequestBody ReactionDTO reactionDTO){
        return new ResponseEntity<Boolean>(reactionService.changeReaction(reactionDTO), HttpStatus.OK);
    }
    
    
    @PostMapping(value = "/",consumes = "application/json")
    public ResponseEntity<Reaction> saveReaction(@RequestBody ReactionDTO reactionDTO){
    	Reaction reaction = reactionService.createReaction(reactionDTO);
        return new ResponseEntity<Reaction>(reaction ,HttpStatus.CREATED);
    }
}
