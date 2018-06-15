package com.demo.userprofile.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "USER_ROLE")
public class UserRole {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name = "ID")
	private Long id;

	@Column(name = "USER_ID")
	private String userId;
	
	@Column(name = "ROLE_ID")
	private String roleId;
	
	@ManyToOne
	@JoinColumns({@JoinColumn(name="userId", referencedColumnName = "userId"),@JoinColumn(name="roleId", referencedColumnName = "roleId")})
	private User user;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserID(String userId) {
		this.userId = userId;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userId=" + userId + ", roleId=" + roleId + "]";
	}

}
