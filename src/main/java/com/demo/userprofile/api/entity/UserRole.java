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
	private String userID;
	
	@Column(name = "ROLE_ID")
	private String roleID;
	
	@ManyToOne
	@JoinColumns({@JoinColumn(name="USER_ID", referencedColumnName = "USER_ID"),@JoinColumn(name="ROLE_ID", referencedColumnName = "ROLE_ID")})
	private User user;
	
	@Override
	public String toString() {
		return "User [id=" + id + ", userID=" + userID + ", roleID=" + roleID + "]";
	}

}
