package embl.recruitment.task.people.api.domain;

import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Entity
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Size(max=100)
	@Column(name = "first_name")
	private String firstName;
	
	@NotBlank
	@Size(max=100)
	@Column(name = "last_name")
	private String lastName;
	
	private Integer age;
	
	@Column(name="age_unit")
	private String ageUnit = "year";
	
	@Size(max=50)
	@Column(name="favourite_colour")
	private String favouriteColour;
	
	@OneToMany(mappedBy = "person",cascade = CascadeType.ALL,orphanRemoval = true)
	private Set<Hobby> hobbies;
	
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="created_by")
	private User createdBy;
	
	@Override
	public int hashCode() {
		return Objects.hashCode(id);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		
		Long objId = ((Person) obj).id;

		return objId==null? false:Objects.equals(id,objId);
	}
	
}
