package main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import spring03.MemberInfoPrinter;
import spring03.MemberRegisterService;
import spring03.RegisterRequest;

public class Main {

	public static void main(String[] args) {
		ApplicationContext ctx = new GenericXmlApplicationContext(
				"classpath:appCtx.xml");
		MemberRegisterService regSvc = ctx.getBean(
				"memberRegSvc", MemberRegisterService.class);
		MemberInfoPrinter infoPrinter = ctx.getBean(
				"infoPrinter", MemberInfoPrinter.class);
		
		RegisterRequest regReq = new RegisterRequest();
		regReq.setEmail("garnet2929@naver.com");
		regReq.setName("강사님");
		regReq.setPassword("1234");
		regReq.setConfirmPassword("1234");
		regSvc.regist(regReq);
		
		infoPrinter.printMemberInfo("garnet2929@naver.com");
	}

}
