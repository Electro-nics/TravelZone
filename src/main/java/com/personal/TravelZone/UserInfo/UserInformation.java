package com.personal.TravelZone.UserInfo;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
@Entity
@Table(name ="UserInformation")
public class UserInformation {
@Id
@SequenceGenerator(name="user_id_sequence",
sequenceName = "user_id_sequence"
		)
@GeneratedValue(
		strategy = GenerationType.SEQUENCE,
		generator="user_id_sequence"
		)
	private Integer userId;
	private String userAddress;
	private String userName;
	private String password;
	private String email;
	private String phone;
	public UserInformation() {}
	public UserInformation(String userAddress, String userName, String password, String email,
			String phone) {
		
		this.userAddress = userAddress;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.phone = phone;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
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
