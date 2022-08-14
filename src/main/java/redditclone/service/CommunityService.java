package redditclone.service;

import java.util.List;

import redditclone.model.dto.CommunityDTO;
import redditclone.model.entity.Community;

public interface CommunityService {

	public List<Community> findAllCommunities();

	public Community createCommunity(CommunityDTO communityDTO);

	public CommunityDTO findCommunityByName(String name);

	public Community updateCommunity(CommunityDTO communityDTO, String oldName);

}
