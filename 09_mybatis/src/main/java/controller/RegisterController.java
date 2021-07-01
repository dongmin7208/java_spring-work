package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import spring.AlreadyExistingMemberException;
import spring.MemberRegisterService;
import spring.RegisterRequest;

@Controller
public class RegisterController {
	
	@RequestMapping("/register/step1")
	
	//@RequestMapping(value="/register/step1", method=RequestMethod.POST)
	public String handleStep1(){
		return "register/step1";
	}
	
	//step2요청을 처리하는 메서드(agree값을 확인하는 기능)
/*	@RequestMapping(value="/register/step2", method=RequestMethod.POST)
	public String handleStep2(HttpServletRequest request){
		String agreeParam = request.getParameter("agree");
		if(agreeParam == null || !agreeParam.equals("true")){
			return "register/step1";
		}
		return "register/step2";
	}*/
	
	//step2요청을 처리하는 메서드(agree값을 확인하는 기능)
//	@RequestMapping(value="/register/step2", method=RequestMethod.POST)
//	public String handleStep2(
//			@RequestParam(value="agree", defaultValue="false")Boolean agree){
//		if(!agree){
//			return "register/step1";
//		}
//		return "register/step2";
//	}
	//form custom태그 사용 시 모델이 추가되도록 위의 step2를 수정
	@RequestMapping(value="/register/step2", method=RequestMethod.POST)
	public String handleStep2(
			@RequestParam(value="agree", defaultValue="false")Boolean agree,
			Model model){
		if(!agree){
			return "register/step1";
		}
		model.addAttribute("formData", new RegisterRequest());	//커맨드 객체 생성
		return "register/step2";
	}
	
	//Get으로 직접 step2요청이 왔을 때 약관페이지로 리다이렉트
	@RequestMapping(value="/register/step2", method=RequestMethod.GET)
	public String handleStep2(){
		return "redirect:/register/step1";
		/*
		 * redirect 경로는 /로 시작하면 절대경로 아니면 상대경로로 인식
		 */
	}
	
	/*
	 * 의존 주입에 사용될 코드
	 */
	private MemberRegisterService memberRegisterService;
	
	public void setMemberRegisterService(
			MemberRegisterService memberRegisterService){
		this.memberRegisterService = memberRegisterService;
	}

	//회원 가입 요청에 동작될 메서드
	/*@RequestMapping(value="/register/step3", method=RequestMethod.POST)
	public String handleStep3(@ModelAttribute("formData")RegisterRequest regReq){
		try{
			memberRegisterService.regist(regReq);
			return "register/step3";
		} catch(AlreadyExistingMemberException e){
			return "register/step2";
		}
	}*/

	//검증 기능 사용
	@RequestMapping(value="/register/step3", method=RequestMethod.POST)
	public String handleStep3(@ModelAttribute("formData")RegisterRequest regReq, 
			Errors errors){
		new RegisterRequestValidator().validate(regReq, errors);
		if(errors.hasErrors()){
			return "register/step2";
		}
		try{
			memberRegisterService.regist(regReq);
			return "register/step3";
		} catch(AlreadyExistingMemberException e){
			errors.rejectValue("email", "duplicate");
			return "register/step2";
		}
	}


}
