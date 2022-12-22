package com.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "hoadonve")
public class Bill {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "maHoaDon")
	private int maHoaDon;
	@Column(name = "tongTien")
	private float tongTien;
	@Column(name = "tGlap")
	private Date tGlap;
	@ManyToOne
	@JoinColumn(name = "maChuyenBay")
	private ChuyenBay maChuyenBays;
	@ManyToOne
	@JoinColumn(name = "maThongTin")
	private TicketDetail maThongTin;
	@ManyToOne
	@JoinColumn(name = "maKhachHang")
	private Customer maKhachHang;
	public Bill(int maHoaDon, float tongTien, Date tGlap, ChuyenBay maChuyenBays, TicketDetail maThongTin,
			Customer maKhachHang) {
		super();
		this.maHoaDon = maHoaDon;
		this.tongTien = tongTien;
		this.tGlap = tGlap;
		this.maChuyenBays = maChuyenBays;
		this.maThongTin = maThongTin;
		this.maKhachHang = maKhachHang;
	}
	public Bill() {
		super();
	}
	public int getMaHoaDon() {
		return maHoaDon;
	}
	public void setMaHoaDon(int maHoaDon) {
		this.maHoaDon = maHoaDon;
	}
	public float getTongTien() {
		return tongTien;
	}
	public void setTongTien(float tongTien) {
		this.tongTien = tongTien;
	}
	public Date gettGlap() {
		return tGlap;
	}
	public void settGlap(Date tGlap) {
		this.tGlap = tGlap;
	}
	public ChuyenBay getMaChuyenBays() {
		return maChuyenBays;
	}
	public void setMaChuyenBays(ChuyenBay maChuyenBays) {
		this.maChuyenBays = maChuyenBays;
	}
	public TicketDetail getMaThongTin() {
		return maThongTin;
	}
	public void setMaThongTin(TicketDetail maThongTin) {
		this.maThongTin = maThongTin;
	}
	public Customer getMaKhachHang() {
		return maKhachHang;
	}
	public void setMaKhachHang(Customer maKhachHang) {
		this.maKhachHang = maKhachHang;
	}
	
	
}
