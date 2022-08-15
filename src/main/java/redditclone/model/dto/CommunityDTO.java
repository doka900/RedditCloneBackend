package redditclone.model.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommunityDTO {

	private long id;
	private String name;
	private String description;
	private LocalDate creationDate;
	private String moderatorUsername;

}
