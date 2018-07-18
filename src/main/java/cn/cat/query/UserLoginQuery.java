package cn.cat.query;

public class UserLoginQuery {
	private String logname;
	private String phone;
	private String mail;
	private String password;

	public String getLogname() {
		return logname;
	}

	public void setLogname(String logname) {
		this.logname = logname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserLoginQuery [logname=" + logname + ", phone=" + phone + ", mail=" + mail + ", password=" + password
				+ "]";
	}



}
