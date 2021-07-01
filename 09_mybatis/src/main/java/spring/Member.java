package spring;

import java.util.Date;

public class Member{
	private Long id;
	private String email;
	private String password;
	private String name;
	private Date regDate;
	
	public Member(){}
	
	public Member(String email, String password, String name, Date registerDate){
		this.email = email;
		this.password = password;
		this.name = name;
		this.regDate = registerDate;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public Long getId() {
		return id;
	}
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	public String getName() {
		return name;
	}
	public Date getRegDate() {
		return regDate;
	}
	
	public boolean matchPassword(String pwd) {
		return this.password.equals(pwd);
	}
	
	//암호변경 기능을 구현하는 메서드
	public void changePassword(String oldPassword, String newPassword){
		if(!password.equals(oldPassword))
			throw new IdPasswordMatchingException();
		this.password = newPassword;
	}
}