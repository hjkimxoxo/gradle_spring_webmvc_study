package gradle_spring_webmvc_study.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import gradle_spring_webmvc_study.spring.LoginCommand;

public class LoginCommandValidator implements Validator {
	private static final String emailRegExp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	private Pattern pattern;

	public LoginCommandValidator(Pattern pattern) {
		this.pattern = pattern;
	}

	public LoginCommandValidator() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return LoginCommand.class.isAssignableFrom(clazz);

	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "required");
		LoginCommand loc = (LoginCommand) target;
		
		Matcher matcher = pattern.matcher(loc.getEmail());
		if (!matcher.matches()) {
			errors.rejectValue("email", "bad");
		}
		ValidationUtils.rejectIfEmpty(errors, "password", "required");

	}

}
