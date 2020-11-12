package gradle_spring_webmvc_study.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import gradle_spring_webmvc_study.dto.Member;
import gradle_spring_webmvc_study.exception.DuplicateMemberException;
import gradle_spring_webmvc_study.service.MemberRegisterService;
import gradle_spring_webmvc_study.spring.MemberDao;
import gradle_spring_webmvc_study.spring.RegisterRequest;

@RestController
public class RestMemberController {
	@Autowired
	private MemberDao memberDao;

	@Autowired
	private MemberRegisterService registerService;

	@GetMapping("/api/members")
	public List<Member> members() {
		return memberDao.selectAll();
	}

	@GetMapping("/api/members/{id}")
	public Member member(@PathVariable Long id, HttpServletResponse response) throws IOException {
		Member member = memberDao.selectById(id);
		if (member == null) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
		return member;
	}

	@PostMapping("/api/members")
	public void newMember(@RequestBody RegisterRequest regReq, HttpServletResponse response) throws IOException {
		try {
			Long newMemberId = registerService.regist(regReq);
			response.setHeader("Location", "/api/members/" + newMemberId);
			response.setStatus(HttpServletResponse.SC_CREATED);
		} catch (DuplicateMemberException e) {
			response.sendError(HttpServletResponse.SC_CONFLICT);
		}
	}
	
	@GetMapping("/memberList")
	public ModelAndView memberList() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("member/members");
		return mav;
	}
	
	@GetMapping("/memberList/{id}")
	public ModelAndView selectMember(@PathVariable Long id) throws IOException {
		Member member = memberDao.selectById(id);
		System.out.println(member);
		ModelAndView mav = new ModelAndView();
		mav.addObject("member", member);
		mav.setViewName("member/memberListDetail");
		return mav;
	}

}
