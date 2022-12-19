package com.controller.maybay;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.model.DuongBay;
import com.model.MayBay;
import com.reponsitory.DaoReponsitory;

@Controller
@RequestMapping(value = "/maybay")
public class AirlineController {

	@Autowired
	private DaoReponsitory<MayBay, Integer> mayBayReponsitory;
	@Autowired
	private DaoReponsitory<DuongBay, Integer> duongbayReponsitory;
	@RequestMapping(value = { "", "/index" })
	public String getListProduct(Model model,
			@RequestParam(value = "page", required = false, defaultValue = "1") int page,
			@RequestParam(value = "name", required = false, defaultValue = "") String name) {

		List<DuongBay> d = duongbayReponsitory.findAll();
		List<MayBay> d1 = mayBayReponsitory.findAll();
		return "admin/maybay/airlineIndex";
	}
}
