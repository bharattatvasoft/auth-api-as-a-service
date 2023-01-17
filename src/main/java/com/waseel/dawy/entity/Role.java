package com.waseel.dawy.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "roles")
@Data
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ROLE_ID")
	private long roleId;

	@Column(name = "ROLE_NAME")
	private String roleName;

	@Column(name = "DESCRIPTION")
	private String description;

	public Role() {
	}

	public Role(String roleName) {
		this.roleName = roleName;
	}

}
