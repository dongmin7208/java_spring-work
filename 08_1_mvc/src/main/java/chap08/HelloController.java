package chap08;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {
		//하나의요청에 하나의 메서드
	@RequestMapping("/hello")
	public String hello(
			Model model,
			@RequestParam(value = "name", required = false) 
			String name) {
		model.addAttribute("greeting", "안녕하세요, " + name);
		System.out.println(name);
		return "hello";
		//스프링한테 리턴되는거 
	}
}
