package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring04.MemberDao;
import spring04.MemberInfoPrinter;
import spring04.MemberPrinter;
import spring04.MemberRegisterService;

@Configuration
public class JavaConfig {
	@Bean
	public MemberDao memberDao() {
		return new MemberDao();
	}
	@Bean
	public MemberRegisterService memberRegSvc() {
		return new MemberRegisterService(memberDao());
	}
	@Bean
	public MemberPrinter printer() {
		return new MemberPrinter();
	}
	@Bean
	public MemberInfoPrinter infoPrinter() {
		MemberInfoPrinter infoPrinter = new MemberInfoPrinter();
		infoPrinter.setMemDao(memberDao());
		infoPrinter.setPrinter(printer());
		return infoPrinter;
	}
}
