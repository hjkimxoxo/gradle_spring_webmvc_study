package gradle_spring_webmvc_study.spring;

public class LoginCommand {
	private String email;
	private String password;
	private boolean rememberEmail;

	public LoginCommand() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LoginCommand(String email, String password, boolean rememberEmail) {
		super();
		this.email = email;
		this.password = password;
		this.rememberEmail = rememberEmail;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isRememberEmail() {
		return rememberEmail;
	}

	public void setRememberEmail(boolean rememberEmail) {
		this.rememberEmail = rememberEmail;
	}

}
