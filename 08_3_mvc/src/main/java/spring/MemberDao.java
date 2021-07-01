package spring;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;
import java.util.Date;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

public class MemberDao {
	private JdbcTemplate jdbcTemplate;
	
	//RowMapper 중복 처리
	private RowMapper<Member> memRowMapper = new RowMapper<Member>(){
		@Override
		public Member mapRow(ResultSet rs, int rowNum) throws SQLException{
			Member member = new Member(rs.getString("EMAIL"),
					rs.getString("PASSWORD"),
					rs.getString("NAME"),
					rs.getTimestamp("REGDATE"));
			member.setId(rs.getLong("ID"));
			return member;
		}
	};

	
	public MemberDao(DataSource dataSource){
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public Member selectByEmail(String email){
		List<Member> results = jdbcTemplate.query(
				"select * from Member where EMAIL = ?",
				memRowMapper, //new MemberRowMapper(),
				email);
		return results.isEmpty() ? null : results.get(0);
	}

	public Collection<Member> selectAll(){
		List<Member> results = jdbcTemplate.query(
				"select * from MEMBER",
				memRowMapper//new MemberRowMapper()
				);
		return results;
	}
	
	public int count(){
		Integer count = jdbcTemplate.queryForObject(
				"select count(*) from MEMBER", Integer.class);
		return count;
	}
	public void update(Member member){
		jdbcTemplate.update(
			"update MEMBER set NAME = ?, PASSWORD = ? where EMAIL = ?",
			member.getName(), member.getPassword(), member.getEmail());
	}

	public void insert(final Member member){
		KeyHolder keyHolder = new GeneratedKeyHolder();
		System.out.println(jdbcTemplate);
		jdbcTemplate.update(new PreparedStatementCreator(){
			@Override
			public PreparedStatement createPreparedStatement(Connection con)
							throws SQLException {
			//파라미터로 전달받은 Connection을 이용해서 PreparedStatement 생성
			String query = "insert into MEMBER (ID, EMAIL, PASSWORD, NAME, REGDATE) values (MEMBER_SEQ.nextval,?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(query, new String[] {"ID"});
			//인덱스 파라미터 값 설정
			pstmt.setString(1, member.getEmail());
			pstmt.setString(2, member.getPassword());
			pstmt.setString(3, member.getName());
			pstmt.setTimestamp(4, new Timestamp(
							member.getRegisterDate().getTime())
			);
			//생성한  PreparedStatement 객체 반환
			return pstmt;
			}
		}, keyHolder);
		Number keyValue = keyHolder.getKey();
		member.setId(keyValue.longValue());
	}

	//날짜를 이용하여 전체 Member목록을 리스트로 반환
	public List<Member> selectByRegdate(Date from, Date to){
		List<Member> results = jdbcTemplate.query(
				"select * from MEMBER where REGDATE between ? and ? "+
				"order by REGDATE desc", memRowMapper/*new RowMapper<Member>()
				{
					@Override
					public Member mapRow(ResultSet rs, int rowNum)
							throws SQLException{
						Member member = new Member(
								rs.getString("EMAIL"),
								rs.getString("PASSWORD"),
								rs.getString("NAME"),
								rs.getTimestamp("REGDATE"));
						member.setId(rs.getLong("ID"));
						return member;
					}
				}*/, from, to);
		return results;
	}
	
	//경로변수(@PathVariable) 테스트를 위한 기능
	public Member selectById(Long id) {
		List<Member> results = jdbcTemplate.query(
				"select * from MEMBER where ID = ?",
				memRowMapper,id);
			return results.isEmpty() ? null : results.get(0);
	}



}
