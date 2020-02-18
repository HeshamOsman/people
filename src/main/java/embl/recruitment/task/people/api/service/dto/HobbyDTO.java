package embl.recruitment.task.people.api.service.dto;

import java.util.Objects;

import embl.recruitment.task.people.api.domain.Hobby;
import lombok.Data;

@Data
public class HobbyDTO {
	private Long id;
	private String name;
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
        Long objId = ((HobbyDTO) obj).id;
		return objId==null? false:Objects.equals(id, objId);
	}
}
