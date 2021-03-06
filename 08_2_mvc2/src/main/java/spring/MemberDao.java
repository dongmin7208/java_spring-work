package spring;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

public class MemberDao {
	private JdbcTemplate jdbcTemplate;
	public MemberDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public Member selectByEmail(String email) {
		List<Member> results = jdbcTemplate.query(
				"select * from Member where EMAIL = ?",
				new MemberRowMapper(),
				email);
		return results.isEmpty() ? null : results.get(0);
	}
	
	public Collection<Member> selectAll(){
		List<Member> results = jdbcTemplate.query(
				"select * from MEMBER",
				new MemberRowMapper());
		return results;
	}
	
	public int count() {
		Integer count = jdbcTemplate.queryForObject(
				"select count(*) from MEMBER", Integer.class);
		return count;
	}
	public void update(Member member) {
		jdbcTemplate.update(
				"update MEMBER set NAME = ?, PASSWORD = ? where EMAIL = ?",
				member.getName(), member.getPassword(), member.getEmail());
	}
	
	public void insert(final Member member) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		System.out.println(jdbcTemplate);
		jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con)
							throws SQLException{
	String query = "insert into MEMBER (ID, EMAIL, PASSWORD, NAME, REGDATE) values (MEMBER_SEQ.nextval,?,?,?,?)";
	PreparedStatement pstmt = con.prepareStatement(query, new String[] {"ID"});
	
	pstmt.setString(1, member.getEmail());
	pstmt.setString(2, member.getPassword());
	pstmt.setString(3, member.getName());
	pstmt.setTimestamp(4, new Timestamp(
					member.getRegisterDate().getTime())
	);
	return pstmt;
	}
},keyHolder);
		Number keyValue = keyHolder.getKey();
		member.setId(keyValue.longValue());
	
}
}
