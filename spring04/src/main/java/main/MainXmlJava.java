package main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import config.JavaMainConf;
import spring04.MemberInfoPrinter;
import spring04.MemberRegisterService;
import spring04.RegisterRequest;

public class MainXmlJava {
	public static void main(String[] args) {
		ApplicationContext ctx =
				new GenericXmlApplicationContext("classpath:main-conf.xml");
				//XML설정과 이 부분만 다름
		MemberRegisterService regSvc =
				ctx.getBean("memberRegSvc", MemberRegisterService.class);
		MemberInfoPrinter infoPrinter =
				ctx.getBean("infoPrinter", MemberInfoPrinter.class);
		
		RegisterRequest regReq = new RegisterRequest();
		regReq.setEmail("garnet2929@naver.com");
		regReq.setName("강사님");
		regReq.setPassword("1234");
		regReq.setConfirmPassword("1234");
		regSvc.regist(regReq);
		
		infoPrinter.printMemberInfo("garnet2929@naver.com");
	}
}
