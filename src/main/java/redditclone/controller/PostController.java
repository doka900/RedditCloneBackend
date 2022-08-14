package redditclone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import redditclone.model.dto.PostDTO;
import redditclone.model.entity.Post;
import redditclone.service.PostService;
@CrossOrigin
@RestController
@RequestMapping("api/post")
public class PostController {
	
	@Autowired
	PostService postService;
	
    @GetMapping(value = "/")
    public ResponseEntity<List<PostDTO>> findAllPosts(){
        return new ResponseEntity<>(postService.findAllPosts(), HttpStatus.OK);
    }
    
    @GetMapping(value = "/{name}/")
    public ResponseEntity<List<PostDTO>> findPostsOfCommunity(@PathVariable("name") String name){
        return new ResponseEntity<>(postService.findPostsOfCommunity(name), HttpStatus.OK);
    }                     
    
    @PostMapping(value = "/",consumes = "application/json")
    public ResponseEntity<Post> createPost(@RequestBody PostDTO postDTO){
        Post newPost = postService.createPost(postDTO);
        return new ResponseEntity<Post>(newPost, HttpStatus.OK);
    }
    
    @DeleteMapping(value ="/{title}/")
    void deletePost(@PathVariable String title) {
        postService.deleteByTitle(title);
      }
}
