package com.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
@Entity
@Table(name ="khachhang")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "maKhachHang")
	private int maKhachHang ;
	@Column(name = "tenKhachHang")
	@NotEmpty(message = "Tên khách hàng không được để trống ")
	private String tenKhachHang;
	@Column(name = "soDienThoai")
	@NotEmpty(message = "Số điện thoại không được để trống ")
	private String soDienThoai ;
	@Column(name = "diaChi")
	@NotEmpty(message = "Địa Chỉ không được để trống ")
	private String diaChi;
	@Column(name = "cmnd")
	@NotEmpty(message = "Căn cước công dân không được để trống ")
	private String cmnd;
	@OneToMany(mappedBy = "maKhachHang")
	private List<Bill> bills;
	public Customer(int maKhachHang, @NotEmpty(message = "Tên khách hàng không được để trống ") String tenKhachHang,
			@NotEmpty(message = "Số điện thoại không được để trống ") String soDienThoai,
			@NotEmpty(message = "Địa Chỉ không được để trống ") String diaChi,
			@NotEmpty(message = "Căn cước công dân không được để trống ") String cmnd, List<Bill> bills) {
		super();
		this.maKhachHang = maKhachHang;
		this.tenKhachHang = tenKhachHang;
		this.soDienThoai = soDienThoai;
		this.diaChi = diaChi;
		this.cmnd = cmnd;
		this.bills = bills;
	}
	public Customer() {
		super();
	}
	public int getMaKhachHang() {
		return maKhachHang;
	}
	public void setMaKhachHang(int maKhachHang) {
		this.maKhachHang = maKhachHang;
	}
	public String getTenKhachHang() {
		return tenKhachHang;
	}
	public void setTenKhachHang(String tenKhachHang) {
		this.tenKhachHang = tenKhachHang;
	}
	public String getSoDienThoai() {
		return soDienThoai;
	}
	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getCmnd() {
		return cmnd;
	}
	public void setCmnd(String cmnd) {
		this.cmnd = cmnd;
	}
	public List<Bill> getBills() {
		return bills;
	}
	public void setBills(List<Bill> bills) {
		this.bills = bills;
	}
	
	
	
	
}
