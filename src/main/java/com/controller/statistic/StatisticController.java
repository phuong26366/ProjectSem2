package com.controller.statistic;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.model.Bill;
import com.reponsitory.BillReponsitory;

@Controller
@RequestMapping(value = "/statistic")
public class StatisticController {
	@Autowired
	private BillReponsitory billReponsitory;

	@RequestMapping(value = { "", "/index" })
	public String getListProduct(
			@RequestParam(value = "start", required = false, defaultValue = "") @DateTimeFormat(pattern = "yyyy-MM-dd") Date start,
			@RequestParam(value = "end", required = false, defaultValue = "") @DateTimeFormat(pattern = "yyyy-MM-dd") Date end,
			Model model) {
		List<Bill> products;
		int tt = 0;
		int stt = 0;
		products = billReponsitory.findAll(start, end);
		for (Bill bill : products) {
			tt += bill.getMaThongTin().getGiaVe();
		}
		model.addAttribute("pros", products);
		model.addAttribute("stt", stt);
		model.addAttribute("tt", tt);
		return "admin/statistic/statisticIndex";
	}

}
