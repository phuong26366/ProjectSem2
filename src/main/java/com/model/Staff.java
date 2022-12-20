package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "nhanvien")
public class Staff {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "maNhanVien")
	private int maNhanVien ;
	@Column(name = "anh")
	@NotEmpty(message = "Ảnh không được để trống ")
	private String image ;
	@Column(name = "tenNhanVien")
	@NotEmpty(message = "Tên nhân viên không được để trống ")
	private String tenNhanVien ;
	@Column(name = "soDienThoai")
	@NotEmpty(message = "Số điện thoại không được để trống ")
	private String soDienThoai ;
	@Column(name = "diaCHi")
	@NotEmpty(message = "Địa chỉ không được để trống ")
	private String diaChi;
	@Column(name = "chucVu")
	@NotNull(message = "Vui long chọn ! ")
	private boolean chucVu;
	@Column(name = "userName")
	@NotEmpty(message = "Tài khoản không được để trống ")
	private String userName ;
	@Column(name = "passWord")
	@NotEmpty(message = "Mật khẩu không được để trống ")
	private String password ;
	@Column(name = "trangThai")
	@NotNull(message = "Vui long chọn ! ")
	private boolean trangThai;
	public Staff(int maNhanVien, @NotEmpty(message = "Ảnh không được để trống ") String image,
			@NotEmpty(message = "Tên nhân viên không được để trống ") String tenNhanVien,
			@NotEmpty(message = "Số điện thoại không được để trống ") String soDienThoai,
			@NotEmpty(message = "Địa chỉ không được để trống ") String diaChi,
			@NotNull(message = "Vui long chọn ! ") boolean chucVu, String userName, String password,
			@NotNull(message = "Vui long chọn ! ") boolean trangThai) {
		super();
		this.maNhanVien = maNhanVien;
		this.image = image;
		this.tenNhanVien = tenNhanVien;
		this.soDienThoai = soDienThoai;
		this.diaChi = diaChi;
		this.chucVu = chucVu;
		this.userName = userName;
		this.password = password;
		this.trangThai = trangThai;
	}
	public Staff() {
		super();
	}
	public int getMaNhanVien() {
		return maNhanVien;
	}
	public void setMaNhanVien(int maNhanVien) {
		this.maNhanVien = maNhanVien;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getTenNhanVien() {
		return tenNhanVien;
	}
	public void setTenNhanVien(String tenNhanVien) {
		this.tenNhanVien = tenNhanVien;
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
	public boolean isChucVu() {
		return chucVu;
	}
	public void setChucVu(boolean chucVu) {
		this.chucVu = chucVu;
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
	public boolean isTrangThai() {
		return trangThai;
	}
	public void setTrangThai(boolean trangThai) {
		this.trangThai = trangThai;
	}
	
}
