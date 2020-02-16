package embl.recruitment.task.people.api.domain;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Size(max=50)
	private String username;
	
	@NotBlank
	@Size(max=100)
	private String password;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="role_id")
	private Role role;
	
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

		return Objects.equals(id, ((User) obj).id);
	}

}
