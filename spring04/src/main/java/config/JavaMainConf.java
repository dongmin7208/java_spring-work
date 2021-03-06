package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import spring04.MemberDao;
import spring04.MemberPrinter;
import spring04.MemberRegisterService;

@Configuration
@ImportResource("classpath:sub-conf.xml")
public class JavaMainConf {

	@Autowired
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
