package gradle_spring_webmvc_study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {
	@GetMapping("/hello")
	public String hello(Model model, @RequestParam(value="name",required = false) String name) {
		model.addAttribute("greeting", "안녕하세요, " + name);  //“greetring”이라는 모델 속성에 값을 설정 JSP 코드는 이 속성을 이용해서 값을 출력
		return "hello"; //컨트롤러의 처리 결과를 보여줄 뷰 이름으로 “hello”를 사용
	}
	
}
