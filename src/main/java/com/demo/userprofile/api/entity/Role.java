package com.demo.userprofile.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import groovy.transform.EqualsAndHashCode;

@Entity
@Table(name = "ROLE")
@EqualsAndHashCode
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", columnDefinition = "INT(11)")
	private Long id;

	@Column(name = "ROLE_NAME")
	private String roleName;
	
	@Column(name = "ROLE_DESCRIPTION")
	private String roleDescription;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleDescription() {
		return roleDescription;
	}

	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", roleName=" + roleName + ", roleDescription=" + roleDescription + "]";
	}

}
