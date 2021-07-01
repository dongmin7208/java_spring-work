package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring04.MemberDao;
import spring04.MemberInfoPrinter;
import spring04.MemberPrinter;

@Configuration
public class ConfigPart2 {
	
	@Autowired
//	private MemberDao memberDao;
	private ConfigPart1 configPart1; //ConfigPart1객체를 의존주입 받도록 지정
	
	@Bean
	public MemberPrinter printer() {
		return new MemberPrinter();
	}
	
	@Bean
	public MemberInfoPrinter infoPrinter() {
		MemberInfoPrinter infoPrinter = new MemberInfoPrinter();
//		infoPrinter.setMemDao(memberDao);
		infoPrinter.setMemDao(configPart1.memberDao());
		infoPrinter.setPrinter(printer());
		return infoPrinter;
	}
}
