package redditclone.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import redditclone.repository.CommunityRepository;
import redditclone.service.CommunityService;

@Service
public class CommunityServiceImplementation implements CommunityService{

	@Autowired
	private CommunityRepository communityRepository;
}
