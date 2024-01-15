package cinema.web.dto;

import javax.validation.constraints.NotBlank;

public class UserRegistrationDTO extends UserDTO {

	@NotBlank(message = "Password is not provided.")
	private String password;

	@NotBlank(message = "Repeated password is not provided.")
	private String repeatedPassword;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRepeatedPassword() {
		return repeatedPassword;
	}

	public void setRepeatedPassword(String repeatedPassword) {
		this.repeatedPassword = repeatedPassword;
	}

}
