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
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "duongbay")
public class Airstrip {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "maDuongBay")
	private int maDuongBay;
	@Column(name = "tenDuongBay")
	@NotEmpty(message = "Tên Đường Bay không được để trống ")
	private String tenDuongBay;
	@Column(name = "viTri")
	@NotEmpty(message = "Vị Trí không được để trống ")
	private String viTri;
	@Column(name = "chieuDai")
	@NotEmpty(message = "Chiều Dài bay không được để trống ")
	private String chieuDai;
	@Column(name = "chieuRong")
	@NotEmpty(message = "Chiều Rộng bay không được để trống ")
	private String chieuRong;
	@Column(name = "trangThai")
	@NotNull(message = "Vui lòng chọn trạng thái !")
	private boolean trangThai;
	@OneToMany(mappedBy = "maDuongBay")
	private List<Flight> chuyenBays;
	public Airstrip(int maDuongBay, @NotNull(message = "Tên Đường Bay không được để trống ") String tenDuongBay,
			@NotEmpty(message = "Vị Trí không được để trống ") String viTri,
			@NotEmpty(message = "Chiều Dài bay không được để trống ") String chieuDai,
			@NotEmpty(message = "Chiều Rộng bay không được để trống ") String chieuRong,
			@NotNull(message = "Vui lòng chọn trạng thái !") boolean trangThai, List<Flight> chuyenBays) {
		super();
		this.maDuongBay = maDuongBay;
		this.tenDuongBay = tenDuongBay;
		this.viTri = viTri;
		this.chieuDai = chieuDai;
		this.chieuRong = chieuRong;
		this.trangThai = trangThai;
		this.chuyenBays = chuyenBays;
	}
	public Airstrip() {
		super();
	}
	public int getMaDuongBay() {
		return maDuongBay;
	}
	public void setMaDuongBay(int maDuongBay) {
		this.maDuongBay = maDuongBay;
	}
	public String getTenDuongBay() {
		return tenDuongBay;
	}
	public void setTenDuongBay(String tenDuongBay) {
		this.tenDuongBay = tenDuongBay;
	}
	public String getViTri() {
		return viTri;
	}
	public void setViTri(String viTri) {
		this.viTri = viTri;
	}
	public String getChieuDai() {
		return chieuDai;
	}
	public void setChieuDai(String chieuDai) {
		this.chieuDai = chieuDai;
	}
	public String getChieuRong() {
		return chieuRong;
	}
	public void setChieuRong(String chieuRong) {
		this.chieuRong = chieuRong;
	}
	public boolean isTrangThai() {
		return trangThai;
	}
	public void setTrangThai(boolean trangThai) {
		this.trangThai = trangThai;
	}
	public List<Flight> getChuyenBays() {
		return chuyenBays;
	}
	public void setChuyenBays(List<Flight> chuyenBays) {
		this.chuyenBays = chuyenBays;
	}

	

	

}
