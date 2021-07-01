package controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spring.AuthInfo;
import spring.ChangePasswordService;
import spring.IdPasswordMatchingException;

@Controller
@RequestMapping("/edit/changePassword")
public class ChangePwdController {
	private ChangePasswordService changePasswordService;
	public void setChangePasswordService(
			ChangePasswordService changePasswordService){
		this.changePasswordService = changePasswordService;
	}
	@RequestMapping(method=RequestMethod.GET)
	public String form(
			@ModelAttribute("command") ChangePwdCommand pwdCmd//, HttpSession session
			){
		//로그인 하지 않은 경우 login페이지로 리다이렉트하는 코드(인터셉터를 구현하여 해결한다.)
/*		if(session.getAttribute("authInfo") == null){
			return "redirect:/login";
		}
*/		return "edit/changePwdForm";
	}
	@RequestMapping(method=RequestMethod.POST)
	public String submit(
			@ModelAttribute("command")ChangePwdCommand pwdCmd,
			Errors errors,
			HttpSession session){
		new ChangePwdCommandValidator().validate(pwdCmd, errors);
		if(errors.hasErrors()){
			return "edit/changePwdForm";
		}
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		//기존의 세션을 가져와서 로그인한 사용자 판별
		try{
			changePasswordService.changePassword(
					authInfo.getEmail(),
					pwdCmd.getCurrentPassword(),
					pwdCmd.getNewPassword());
			return "edit/changePwd";
		} catch (IdPasswordMatchingException e){
			errors.rejectValue("currentPassword", "notMatching");
			return "edit/changePwdForm";
		}
	}
}
