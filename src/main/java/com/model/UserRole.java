package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "UserRole")
public class UserRole {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "urid")
	private int urid;
	@ManyToOne
	@JoinColumn(name = "maNhanVien")
	private Staff maNhanVien;
	@ManyToOne
	@JoinColumn(name = "rid")
	private Role role;

	public UserRole(int urid, Staff maNhanVien, Role role) {
		super();
		this.urid = urid;
		this.maNhanVien = maNhanVien;
		this.role = role;
	}

	public UserRole() {
		super();
	}

	public int getUrid() {
		return urid;
	}

	public void setUrid(int urid) {
		this.urid = urid;
	}

	public Staff getMaNhanVien() {
		return maNhanVien;
	}

	public void setMaNhanVien(Staff maNhanVien) {
		this.maNhanVien = maNhanVien;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}
