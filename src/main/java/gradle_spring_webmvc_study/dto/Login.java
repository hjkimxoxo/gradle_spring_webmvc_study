package gradle_spring_webmvc_study.dto;

import java.util.Arrays;

public class Login {
	// 항목 => path
	private String loginType;
	private String jobCode;
	private String tools;
	private String[] favoriteOs;
	private String[] favoriteOs2;

	public Login() {
	}

	public String[] getFavoriteOs() {
		return favoriteOs;
	}

	public void setFavoriteOs(String[] favoriteOs) {
		this.favoriteOs = favoriteOs;
	}

	public String[] getFavoriteOs2() {
		return favoriteOs2;
	}

	public void setFavoriteOs2(String[] favoriteOs2) {
		this.favoriteOs2 = favoriteOs2;
	}

	public String getTools() {
		return tools;
	}

	public void setTools(String tools) {
		this.tools = tools;
	}

	public String getJobCode() {
		return jobCode;
	}

	public String getLoginType() {
		return loginType;
	}

	public void setLoginType(String loginType) {
		this.loginType = loginType;
	}

	public void setJobCode(String jobCode) {
		this.jobCode = jobCode;
	}

	@Override
	public String toString() {
		return String.format("Login [loginType=%s, jobCode=%s, tools=%s, favoriteOs=%s, favoriteOs2=%s]", loginType,
				jobCode, tools, Arrays.toString(favoriteOs), Arrays.toString(favoriteOs2));
	}

	

}
