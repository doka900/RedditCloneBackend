package redditclone.model.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "posts")
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "post_id", unique = true, nullable = false)
	private Long id;

	@Column
	private String title;

	@Column
	private String text;

	@Column
	private LocalDate creation_date;

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "community_id", nullable = false)
	private Community community;

	@JoinColumn(name = "author_id", referencedColumnName = "id", nullable = false)
	@ManyToOne(fetch = FetchType.EAGER)
	private User author;

}