package com.personal.TravelZone.UserInfo;

import java.util.Objects;

public class UserInformation {
	private String userId;
	private String userAddress;
	private String userName;
	private String password;
	private String email;
	private long phone;
	public UserInformation() {}
	public UserInformation(String userId, String userAddress, String userName, String password, String email,
			long phone) {
		this.userId = userId;
		this.userAddress = userAddress;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.phone = phone;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	@Override
	public int hashCode() {
		return Objects.hash(email, password, phone, userAddress, userId, userName);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserInformation other = (UserInformation) obj;
		return Objects.equals(email, other.email) && Objects.equals(password, other.password) && phone == other.phone
				&& Objects.equals(userAddress, other.userAddress) && Objects.equals(userId, other.userId)
				&& Objects.equals(userName, other.userName);
	}
	@Override
	public String toString() {
		return "UserInformation [userId=" + userId + ", userAddress=" + userAddress + ", userName=" + userName
				+ ", password=" + password + ", email=" + email + ", phone=" + phone + "]";
	} 
	
	

}
