package redditclone.model.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="reaction")
public class Reaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long reaction_id;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "reaction_type")
	private ReactionType reaction_type;
	
	@Column
	private LocalDate time_stamp;
	
	@Column
	private long voter_id;
	
	@Column
	private long post_id;
	
	
}
