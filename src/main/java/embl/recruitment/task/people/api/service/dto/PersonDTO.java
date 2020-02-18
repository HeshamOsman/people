package embl.recruitment.task.people.api.service.dto;


import java.util.Objects;
import java.util.Set;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class PersonDTO {

    private Long id;
	
	@NotBlank
	@Size(max=100)
	private String firstName;
	
	@NotBlank
	@Size(max=100)
	private String lastName;
	
	private Integer age;
	
	@Size(max=50)
	private String favouriteColour;
	
	private Set<HobbyDTO> hobbies;
	
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
        Long objId = ((PersonDTO) obj).id;
		return objId==null? false:Objects.equals(id, objId);
	}
}
