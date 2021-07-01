package spring;

import java.util.Collection;
import java.util.Date;
import java.util.List;

public interface MemberDao {
	public Member selectByEmail(String email);
	public Collection<Member> selectAll();
	public int count();
	public void update(Member member);
	public void insert(final Member member);
	//날짜를 이용하여 전체 Member목록을 리스트로 반환
	public List<Member> selectByRegdate(Date from, Date to);
	//경로변수(@PathVariable) 테스트를 위한 기능
	public Member selectById(Long id);


}
