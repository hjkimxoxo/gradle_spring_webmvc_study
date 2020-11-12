package gradle_spring_webmvc_study.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import gradle_spring_webmvc_study.exception.WrongIdPasswordException;

//@JsonIgnoreProperties({"password"})
public class Member {

	private Long id;
	private String email;
	private String password;
	private String name;
	
	//@JsonFormat(pattern = "yyyyMMddHHmmss")
	private LocalDateTime registerDateTime;

	
	public Member(String email, String password, 
			String name, LocalDateTime regDateTime) {
		this.email = email;
		this.password = password;
		this.name = name;
		this.registerDateTime = regDateTime;
	}


	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getName() {
		return name;
	}

	public LocalDateTime getRegisterDateTime() {
		return registerDateTime;
	}

	public void changePassword(String oldPassword, String newPassword) {
		if (!password.equals(oldPassword))
			throw new WrongIdPasswordException(newPassword);
		this.password = newPassword;
	}
	
	public boolean matchPassword(String password) {
		return this.password.equals(password);
	}


	@Override
	public String toString() {
		return String.format("Member [id=%s, email=%s, password=%s, name=%s, registerDateTime=%s]", id, email, password,
				name, registerDateTime);
	}

	
}
