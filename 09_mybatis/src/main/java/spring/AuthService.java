package spring;

public class AuthService {
	private MemberDaoImpl memberDao;
	
	public void setMemberDao(MemberDaoImpl memberDao){
		this.memberDao = memberDao;
	}
	
	public AuthInfo authenticate(String email, String password){
		Member member = memberDao.selectByEmail(email);
		if(member == null){
			throw new IdPasswordMatchingException();
		}
		if(!member.matchPassword(password)){
			throw new IdPasswordMatchingException();
		}
		return new AuthInfo(member.getId(), member.getEmail(), member.getName());
	}
}
