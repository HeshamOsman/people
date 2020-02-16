package embl.recruitment.task.people.api.rest.representation;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

public class JwtRequest implements Serializable {
	private static final long serialVersionUID = 5926468583005150707L;
	@NotBlank
	private String username;
	@NotBlank
	private String password;
	public JwtRequest()
	{
	}
	public JwtRequest(String username, String password) {
	this.setUsername(username);
	this.setPassword(password);
	}
	public String getUsername() {
	return this.username;
	}
	public void setUsername(String username) {
	this.username = username;
	}
	public String getPassword() {
	return this.password;
	}
	public void setPassword(String password) {
	this.password = password;
	}
}
