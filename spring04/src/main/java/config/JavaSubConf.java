package config;

import javax.annotation.Resource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring04.MemberDao;
import spring04.MemberPrinter;
import spring04.MemberRegisterService;

@Configuration
public class JavaSubConf {
	
	@Resource(name="memberDao")
	private MemberDao memberDao;
	
	@Bean
	public MemberPrinter memberPrinter() {
		return new MemberPrinter();
	}
	
	@Bean
	public MemberRegisterService memberRegSvc() {
		return new MemberRegisterService(memberDao);
	}
}
