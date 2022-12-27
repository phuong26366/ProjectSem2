package com.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Role")
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "rid")
	private int rid;
	@Column(name = "roleName")
	private String roleName;
	@Column(name = "status")
	private Boolean satatus;
	@OneToMany(mappedBy = "role", fetch = FetchType.EAGER)
	private List<UserRole> roles;

	public Role(int rid, String roleName, Boolean satatus, List<UserRole> users) {
		super();
		this.rid = rid;
		this.roleName = roleName;
		this.satatus = satatus;
		this.roles = users;
	}

	public Role() {
		super();
	}

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Boolean getSatatus() {
		return satatus;
	}

	public void setSatatus(Boolean satatus) {
		this.satatus = satatus;
	}

	public List<UserRole> getUsers() {
		return roles;
	}

	public void setUsers(List<UserRole> users) {
		this.roles = users;
	}
}
