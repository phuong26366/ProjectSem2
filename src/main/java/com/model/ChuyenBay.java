package com.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "chuyenbay")
public class ChuyenBay {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "maChuyenBay")
	private int maChuyenBay;
	@Column(name = "tenChuyenBay")
	@NotNull(message = "Tên Chuyến Bay không được để trống ")
	private String tenChuyenBay;
	@Column(name = "ngayBay")
	@NotNull(message = "Ngày bay không được để trống ")
	private Date ngayBay;
	@Column(name = "diemDi")
	@NotEmpty(message = "Điểm đi không được để trống ")
	private String diemDi;
	@Column(name = "diemDen")
	@NotEmpty(message = "Điểm Đến không được để trống ")
	private String diemDen;
	@Column(name = "gioBay")
	@NotNull(message = "Giờ bay không được để trống ")
	private String gioBay;
	@Column(name = "trangThai")
	@NotNull(message = "Vui lòng chọn trạng thái !")
	private boolean trangThai;
	@ManyToOne
	@JoinColumn(name = "maMAYBAY")
	@NotNull(message = "Vui lòng chọn mã máy bay")
	private MayBay maMayBay;
	@ManyToOne
	@JoinColumn(name = "maDuongBay")
	@NotNull(message = "Vui lòng chọn mã máy bay")
	private DuongBay maDuongBay;
	@OneToMany(mappedBy = "maChuyenBay")
	private List<TicketDetail> ticketDetails;
	@OneToMany(mappedBy = "maChuyenBays")
	private List<Bill> bills;
	public ChuyenBay(int maChuyenBay, @NotNull(message = "Tên Chuyến Bay không được để trống ") String tenChuyenBay,
			@NotNull(message = "Ngày bay không được để trống ") Date ngayBay,
			@NotEmpty(message = "Điểm đi không được để trống ") String diemDi,
			@NotEmpty(message = "Điểm Đến không được để trống ") String diemDen,
			@NotNull(message = "Giờ bay không được để trống ") String gioBay,
			@NotNull(message = "Vui lòng chọn trạng thái !") boolean trangThai,
			@NotNull(message = "Vui lòng chọn mã máy bay") MayBay maMayBay,
			@NotNull(message = "Vui lòng chọn mã máy bay") DuongBay maDuongBay, List<TicketDetail> ticketDetails,
			List<Bill> bills) {
		super();
		this.maChuyenBay = maChuyenBay;
		this.tenChuyenBay = tenChuyenBay;
		this.ngayBay = ngayBay;
		this.diemDi = diemDi;
		this.diemDen = diemDen;
		this.gioBay = gioBay;
		this.trangThai = trangThai;
		this.maMayBay = maMayBay;
		this.maDuongBay = maDuongBay;
		this.ticketDetails = ticketDetails;
		this.bills = bills;
	}
	public ChuyenBay() {
		super();
	}
	public int getMaChuyenBay() {
		return maChuyenBay;
	}
	public void setMaChuyenBay(int maChuyenBay) {
		this.maChuyenBay = maChuyenBay;
	}
	public String getTenChuyenBay() {
		return tenChuyenBay;
	}
	public void setTenChuyenBay(String tenChuyenBay) {
		this.tenChuyenBay = tenChuyenBay;
	}
	public Date getNgayBay() {
		return ngayBay;
	}
	public void setNgayBay(Date ngayBay) {
		this.ngayBay = ngayBay;
	}
	public String getDiemDi() {
		return diemDi;
	}
	public void setDiemDi(String diemDi) {
		this.diemDi = diemDi;
	}
	public String getDiemDen() {
		return diemDen;
	}
	public void setDiemDen(String diemDen) {
		this.diemDen = diemDen;
	}
	public String getGioBay() {
		return gioBay;
	}
	public void setGioBay(String gioBay) {
		this.gioBay = gioBay;
	}
	public boolean isTrangThai() {
		return trangThai;
	}
	public void setTrangThai(boolean trangThai) {
		this.trangThai = trangThai;
	}
	public MayBay getMaMayBay() {
		return maMayBay;
	}
	public void setMaMayBay(MayBay maMayBay) {
		this.maMayBay = maMayBay;
	}
	public DuongBay getMaDuongBay() {
		return maDuongBay;
	}
	public void setMaDuongBay(DuongBay maDuongBay) {
		this.maDuongBay = maDuongBay;
	}
	public List<TicketDetail> getTicketDetails() {
		return ticketDetails;
	}
	public void setTicketDetails(List<TicketDetail> ticketDetails) {
		this.ticketDetails = ticketDetails;
	}
	public List<Bill> getBills() {
		return bills;
	}
	public void setBills(List<Bill> bills) {
		this.bills = bills;
	}
	
}
