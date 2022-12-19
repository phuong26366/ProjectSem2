package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(value = "/")
public class test {
	@RequestMapping(value = "/test")
	public String home() {
		return "hellojsp";
	}
	@RequestMapping(value = "/datve")
	public String datve() {
		return "admin/datVeMayBay/datVeMayBay";
	}
	@RequestMapping(value = "/addmaybay")
	public String addmaybay() {
		return "admin/maybay/addMayBay";
	}
	@RequestMapping(value = "/addduongbay")
	public String addduongbay() {
		return "admin/duongbay/addDuongBay";
	}
	@RequestMapping(value = "/addnhanvien")
	public String addnhanvien() {
		return "admin/nhanvien/addNhanVien";
	}
	@RequestMapping(value = "/addttve")
	public String addttve() {
		return "admin/thongtinve/addThongTinVe";
	}
	@RequestMapping(value = "/addchuyenbay")
	public String addchuyenbay() {
		return "admin/chuyenbay/addChuyenBay";
	}
}
