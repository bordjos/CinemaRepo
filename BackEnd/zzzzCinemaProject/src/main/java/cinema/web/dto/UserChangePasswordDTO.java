package cinema.web.dto;

public class UserChangePasswordDTO {

	// @NotBlank(message = "Korisnicko ime nije zadato.")
	private String username;

	// @NotBlank(message = "Stara lozinka nije zadata.")
	private String oldPassword;

	// @NotBlank(message = "Password ....")
	private String password;

	// @NotBlank(message = "Please repeat the password.")
	private String repeatedPassword;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

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
