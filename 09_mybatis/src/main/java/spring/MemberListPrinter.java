package spring;

import java.util.Collection;

public class MemberListPrinter {
	
	private MemberDaoImpl memberDao;
	private MemberPrinter printer;
	
	public MemberListPrinter(MemberDaoImpl memberDao, MemberPrinter printer){
		this.memberDao = memberDao;
		this.printer = printer;
	}
	
	public void printAll(){
		Collection<Member> members = memberDao.selectAll();
		for(Member m : members){
			printer.print(m);
		}
	}
}
