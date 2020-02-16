package embl.recruitment.task.people.api.domain;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.security.core.GrantedAuthority;

import lombok.Data;

@Data
@Entity
public class Role implements GrantedAuthority {
 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Size(max=50)
	private String slug;
	
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

		return Objects.equals(id, ((Role) obj).id);
	}



	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return slug;
	}
}
