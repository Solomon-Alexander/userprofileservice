package com.demo.userprofile.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;

import groovy.transform.EqualsAndHashCode;

@Entity
@Table(name = "USER_GROUP")
@EqualsAndHashCode
public class UserGroup {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", columnDefinition = "INT(11)")
	private Long id;

	@Column(name = "USER_ID", columnDefinition = "INT(11)")
	private Long userId;
	
	@Column(name = "GROUP_ID", columnDefinition = "INT(11)")
	@ColumnDefault("1")
	private Long groupId;

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

	public Long getGroupId() {
		return groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userId=" + userId + ", groupId=" + groupId + "]";
	}

}
