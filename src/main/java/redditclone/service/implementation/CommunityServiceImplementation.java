package redditclone.service.implementation;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import redditclone.model.dto.CommunityDTO;
import redditclone.model.entity.Community;
import redditclone.repository.CommunityRepository;
import redditclone.repository.UserRepository;
import redditclone.service.CommunityService;

@Service
public class CommunityServiceImplementation implements CommunityService{

	@Autowired
	private CommunityRepository communityRepository;
	
	@Autowired 
	UserRepository userRepository;
	
	@Override
	public List<Community> findAllCommunities() {
		return communityRepository.findAll();
	}

	@Override
	public Community createCommunity(CommunityDTO communityDTO) {
		Community newCommunity = new Community();			
		newCommunity.setModerator(userRepository.findByUsername(communityDTO.getModeratorUsername()));
		newCommunity.setName(communityDTO.getName());
		newCommunity.setCreation_date(LocalDate.now());
		newCommunity.setDescription(communityDTO.getDescription()); 

	    communityRepository.save(newCommunity);
	    return newCommunity;
	}

	@Override
	public CommunityDTO findCommunityByName(String name) {
		Community community = communityRepository.findByName(name);
		CommunityDTO communityDTO = new CommunityDTO();
		communityDTO.setId(community.getId());
		communityDTO.setCreationDate(community.getCreation_date());
		communityDTO.setDescription(community.getDescription());
		communityDTO.setName(community.getName());
		communityDTO.setModeratorUsername(community.getModerator().getUsername());

	    return communityDTO;
	}
	
	public Community updateCommunity(CommunityDTO communityDTO, String oldName) {

		Community community = communityRepository.findByName(oldName);

	    if (!communityDTO.getName().equals(null)){
	    	community.setName(communityDTO.getName());
	    }
	    if (!communityDTO.getDescription().equals(null)){
	    	community.setDescription(communityDTO.getDescription());
	    }
	    
	    communityRepository.updateCommunity(communityDTO.getName(), communityDTO.getDescription(), communityDTO.getId());
	    return community;
	}

}
