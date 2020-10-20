package gradle_spring_webmvc_study.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

import gradle_spring_webmvc_study.dto.Member;
import gradle_spring_webmvc_study.exception.DuplicateMemberException;
import gradle_spring_webmvc_study.spring.MemberDao;
import gradle_spring_webmvc_study.spring.RegisterRequest;

@Component
public class MemberRegisterService {
    
    private MemberDao memberDao;

    @Autowired
    public MemberRegisterService(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    public Long regist(RegisterRequest req) {
        Member member = null;
        try {
           member = memberDao.selectByEmail(req.getEmail());
            if (member != null) {
                throw new DuplicateMemberException("dup email " + req.getEmail());
            }
        } catch (EmptyResultDataAccessException e) {
        }

        Member newMember = new Member(req.getEmail(), req.getPassword(), req.getName(), LocalDateTime.now());
        memberDao.insert(newMember);
        return newMember.getId();
    }

}
