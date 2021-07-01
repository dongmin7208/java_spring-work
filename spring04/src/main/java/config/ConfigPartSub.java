package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring04.MemberDao;
import spring04.MemberInfoPrinter;
import spring04.MemberPrinter;

@Configuration
public class ConfigPartSub {
	
	@Autowired
	private MemberDao memberDao;
	
	@Bean
	public MemberPrinter printer() {
		return new MemberPrinter();
	}
	
	@Bean
	public MemberInfoPrinter infoPrinter() {
		MemberInfoPrinter infoPrinter = new MemberInfoPrinter();
		infoPrinter.setMemDao(memberDao);
		infoPrinter.setPrinter(printer());
		return infoPrinter;
	}
}
