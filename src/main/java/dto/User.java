package dto;

import lombok.Getter;

import java.sql.Date;



@Getter
public class User {

	///Method
	///Field
	private Long userId;
	private String userName;
	private String password;
	private String role;
	private String ssn;
	private String phone;
	private String addr;
	private String email;
	private Date regDate;

	private String phone1;
	private String phone2;
	private String phone3;

	
	
	///Constructor
	public User(){
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public void setPhone(String phone) {
		this.phone = phone;

		if(phone != null && phone.length() !=0 ){
			phone1 = phone.split("-")[0];
			phone2 = phone.split("-")[1];
			phone3 = phone.split("-")[2];
		}
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "UserVO : [userId] "+userId+" [userName] "+userName+" [password] "+password+" [role] "+ role
			+" [ssn] "+ssn+" [phone] "+phone+" [email] "+email+" [regDate] "+regDate;
	}
	
	////////////////////////////////////////////////////////////////////////////////////////
	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}
	
	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}
	
	public void setPhone3(String phone3) {
		this.phone3 = phone3;
	}
	/////////////////////////////////////////////////////////////////////////////////////////
}