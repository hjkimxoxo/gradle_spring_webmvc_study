package gradle_spring_webmvc_study.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import gradle_spring_webmvc_study.dto.Code;
import gradle_spring_webmvc_study.dto.Login;

@Controller
public class LoginController {
	
//	@GetMapping("/login")
//	public ModelAndView form1(Model model, Login login) {
//		List<String> loginTypes = new ArrayList<>();
//		loginTypes.add("일반회원");
//		loginTypes.add("기업회원");
//		loginTypes.add("헤드헌터회원");
//		
//		ModelAndView mav = new ModelAndView();
//		mav.addObject("loginTypes", loginTypes);
//		mav.setViewName("login/loginForm");
//		model.addAttribute("login", new Login());
//		return mav;
//	}
	
	@GetMapping("/login")
	public String form1(Login login) {
		login.setLoginType("기업회원");
		login.setJobCode("B");
		login.setTools("Eclipse");
		
		String[] f1 = {"리눅스", "유닉스", "우분투"};
		login.setFavoriteOs(f1);
		
		String[] f2 = {"O1", "O3"};
		login.setFavoriteOs2(f2);
		
		return "login/loginForm";
	}
	
	
	@PostMapping("/result")
	public String result(@ModelAttribute("login") Login login){
		return "login/result";
	}
	
	@ModelAttribute("loginType")
	public List<String> loginTypes(){
	List<String> loginTypes = new ArrayList<>();
		loginTypes.add("일반회원");
		loginTypes.add("기업회원");
		loginTypes.add("헤드헌터회원");
		return loginTypes;
	}
	
	@ModelAttribute("jobCodes")
	public List<Code> getJobCodes(){
		List<Code> jobCodes = new ArrayList<>();
		jobCodes.add(new Code("A", "사용자"));
	    jobCodes.add(new Code("B", "관리자"));
	    jobCodes.add(new Code("C", "개발자"));
		return jobCodes;
	}
	
	@ModelAttribute("tools")
	public List<String> getTools(){
		List<String> tools = new ArrayList<String>();
		tools.add("Eclipse");
		tools.add("InteliJ");
		tools.add("VSCode");
		return tools;
	}
	
	@ModelAttribute("favoriteOs")
	public List<String> favoriteOs(){
		List<String> favoriteOs = new ArrayList<>();
		favoriteOs.add("윈도우10");
		favoriteOs.add("리눅스");
		favoriteOs.add("유닉스");
		favoriteOs.add("칼리리눅스");
		favoriteOs.add("우분투");
		return favoriteOs;
	}
	
	@ModelAttribute("favoriteOs2")
	public List<Code> getOsCode(){
		List<Code> code = new ArrayList<Code>();
		code.add(new Code("O1","윈도우10"));
		code.add(new Code("O2","리눅스"));
		code.add(new Code("O3","유닉스"));
		code.add(new Code("O4","칼리리눅스"));
		code.add(new Code("O5","우분투"));
		return code;
	}
	
	
	
	
	
}