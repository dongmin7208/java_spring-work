package spring;

public class ChangePasswordService {
	private MemberDaoImpl memberDao;
	
	public ChangePasswordService(MemberDaoImpl memberDao){
		this.memberDao = memberDao;
	}
	
	public void changePassword(String email, String oldPwd, String newPwd){
		Member member = memberDao.selectByEmail(email);
		if(member == null){
			throw new MemberNotFoundException();
		}
		member.changePassword(oldPwd,  newPwd);
		memberDao.update(member);
	}
}
