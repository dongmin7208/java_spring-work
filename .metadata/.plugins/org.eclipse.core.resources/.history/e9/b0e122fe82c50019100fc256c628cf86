package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mchange.util.AlreadyExistsException;

@Controller
public class RegisterController {
	@RequestMapping("/register/step1")
	public String handleStep1() {
		return "register/step1";
	}
	@RequestMapping(value="/register/step2", method=RequestMethod.POST)
	public String handleStep2(
		@RequestParam(value="agree", defaultValue="false")boolean agree,
		Model model) {
		if(!agree) {
			return "register/step1";
		}
		model.addAttribute("formData", new RegisterRequest()); //커맨드객체
		return "register/step2";
	}
	
	@RequestMapping(value="/register/step2", method=RequestMethod.GET)
	public String handleStep2() {
		return "redirect:/register/step1";
	}
	
	//의존주입에 사용될 코드
	private MemberRegisterService memberRegisterService;
	
	public void setMemberRegisterService(
			MemberRegisterService memberRegisterService) {
		this.memberRegisterService = memberRegisterService;
	}
	
	//검증기능사용
	@RequestMapping(value="/register/step3", method=RequestMethod.POST)
	public String handleSter3(@ModelAttribute("formData")RegisterRequest regReq,
			Errors errors) {
		new RegisterRequestValidator().validate(regReq, errors);
		if(errors.hasErrors()) {
				return "register/step2";
		}
		try {
				memberRegisterService.regist(regReq);
				return "register/step3";
		}catch (AlreadyExistsException e) {
				errors.rejectValue("email", "duplicate");
				return "register/step2";
		}
	}
}
