package controller;

import org.springframework.beans.TypeMismatchException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import spring.Member;
import spring.MemberDaoImpl;
import spring.MemberNotFoundException;

@Controller
public class MemberDetailController {
	private MemberDaoImpl memberDao;
	
	public void setMemberDao(MemberDaoImpl memberDao){
		this.memberDao = memberDao;
	}
	@RequestMapping("/member/detail/{id}")
	public String detail(@PathVariable("id")Long memId, Model model){
		Member member = memberDao.selectById(memId);
		if(member == null){ throw new MemberNotFoundException(); }
		model.addAttribute("member", member);
		return "member/memberDetail";
	}
	
	//예외 처리
	@ExceptionHandler(TypeMismatchException.class)
	public String handleTypeMismatchException(){
		return "member/invalidId";	
	}
	
//	@ExceptionHandler(MemberNotFoundException.class)
//	public String handleMemberNotFoundException(){
//		return "member/noMember";
//	}

} 
