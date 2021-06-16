package jp.co.example.entity;

public class User {
	private Integer userId;
	private String userName;
	private String telNo;

	public User() {
	}

	public User(Integer userId, String userName, String telNo) {
		this.userId = userId;
		this.userName = userName;
		this.telNo = telNo;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getTelNo() {
		return telNo;
	}
	public void setTelNo(String telNo) {
		this.telNo = telNo;
	}
	public String getUserInfo() {
		return "User [id=" + userId + ", name=" + userName + ", tel=" + telNo + "]";
	}
}