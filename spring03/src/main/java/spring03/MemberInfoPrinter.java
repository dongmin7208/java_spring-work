package spring03;

import org.springframework.beans.factory.annotation.Autowired;

public class MemberInfoPrinter {
	
	@Autowired
	private MemberDao memDao;
	private MemberPrinter printer;
	
	public void setMemDao(MemberDao memDao) {
		this.memDao = memDao;
	}
	
	@Autowired
	public void setPrinter(MemberPrinter printer1) {
		this.printer = printer1;
	}
	
	public void printMemberInfo(String email) {
		Member member = memDao.selectByEmail(email);
		if(member == null) {
			System.out.println("정보 없음!\n");
			return;
		}
		printer.print(member);;
		System.out.println();
	}	
}
