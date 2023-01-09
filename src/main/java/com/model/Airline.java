package com.model;

import java.util.List;
import java.util.Objects;

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
@Table(name = "maybay")
public class Airline {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "maMAYBAY")
	private int maMayBay;
	@Column(name = "tenMayBay")
	@NotEmpty(message = "Tên máy bay không được để trống ")
	private String tenMayBay;
	@Column(name = "hangSanXuat")
	@NotEmpty(message = "Hãng sản xuất không được để trống ")
	private String hangSanXuat;
	@Column(name = "kichTHuoc")
	@NotEmpty(message = "Kích thước không được để trống ")
	private String kichThuoc;
	@Column(name = "soGheL1")
	private int soGheL1;
	@Column(name = "soGheL2")
	private int soGheL2;
	@Column(name = "tongGhe")
	private int tongGhe;
	@Column(name = "trangThai")
	@NotNull(message = "Vui lòng chọn trạng thái !")
	private boolean trangThai;
	@OneToMany(mappedBy = "maMayBay")
	private List<Flight> chuyenBays;

	public Airline(int maMayBay, @NotEmpty(message = "Tên máy bay không được để trống ") String tenMayBay,
			@NotEmpty(message = "Hãng sản xuất không được để trống ") String hangSanXuat,
			@NotEmpty(message = "Kích thước không được để trống ") String kichThuoc, int soGheL1, int soGheL2,
			int tongGhe, @NotNull(message = "Vui lòng chọn trạng thái !") boolean trangThai, List<Flight> chuyenBays) {
		super();
		this.maMayBay = maMayBay;
		this.tenMayBay = tenMayBay;
		this.hangSanXuat = hangSanXuat;
		this.kichThuoc = kichThuoc;
		this.soGheL1 = soGheL1;
		this.soGheL2 = soGheL2;
		this.tongGhe = tongGhe;
		this.trangThai = trangThai;
		this.chuyenBays = chuyenBays;
	}

	public Airline() {
		super();
	}

	@Override
	public int hashCode() {
		return Objects.hash(maMayBay);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Airline other = (Airline) obj;
		return maMayBay == other.maMayBay;
	}

	public int getMaMayBay() {
		return maMayBay;
	}

	public void setMaMayBay(int maMayBay) {
		this.maMayBay = maMayBay;
	}

	public String getTenMayBay() {
		return tenMayBay;
	}

	public void setTenMayBay(String tenMayBay) {
		this.tenMayBay = tenMayBay;
	}

	public String getHangSanXuat() {
		return hangSanXuat;
	}

	public void setHangSanXuat(String hangSanXuat) {
		this.hangSanXuat = hangSanXuat;
	}

	public String getKichThuoc() {
		return kichThuoc;
	}

	public void setKichThuoc(String kichThuoc) {
		this.kichThuoc = kichThuoc;
	}

	public int getSoGheL1() {
		return soGheL1;
	}

	public void setSoGheL1(int soGheL1) {
		this.soGheL1 = soGheL1;
	}

	public int getSoGheL2() {
		return soGheL2;
	}

	public void setSoGheL2(int soGheL2) {
		this.soGheL2 = soGheL2;
	}

	public int getTongGhe() {
		return tongGhe;
	}

	public void setTongGhe(int tongGhe) {
		this.tongGhe = tongGhe;
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
