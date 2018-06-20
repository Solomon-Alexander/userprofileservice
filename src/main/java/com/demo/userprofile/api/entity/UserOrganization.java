package com.demo.userprofile.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import groovy.transform.EqualsAndHashCode;

@Entity
@Table(name = "USER_ORGANIZATION")
@EqualsAndHashCode
public class UserOrganization {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", columnDefinition = "INT(11)")
	private Long id;

	@Column(name = "USER_ID", columnDefinition = "INT(11)")
	private Long userId;
	
	@Column(name = "ORGANIZATION_ID", columnDefinition = "INT(11)")
	private Long organizationId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserID(Long userId) {
		this.userId = userId;
	}

	public Long getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Long organizationId) {
		this.organizationId = organizationId;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userId=" + userId + ", organizationId=" + organizationId + "]";
	}

}
