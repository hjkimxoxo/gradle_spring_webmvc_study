package gradle_spring_webmvc_study.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gradle_spring_webmvc_study.dto.AuthInfo;
import gradle_spring_webmvc_study.dto.Member;
import gradle_spring_webmvc_study.exception.WrongIdPasswordException;
import gradle_spring_webmvc_study.spring.MemberDao;

@Component
public class AuthService {

	@Autowired
	private MemberDao memberDao;

	public AuthInfo authenicate(String email, String password) {
		Member member = memberDao.selectByEmail(email);
		if (member == null) {
			throw new WrongIdPasswordException(email);
		}
		if (!member.matchPassword(password)) {
			throw new WrongIdPasswordException(password);
		}
		return new AuthInfo(member.getId(), member.getEmail(), member.getName());
	}

}
