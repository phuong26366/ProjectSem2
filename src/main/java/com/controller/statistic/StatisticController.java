package com.controller.statistic;

import java.util.List;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.model.Bill;
import com.model.TicketDetail;
import com.reponsitory.BillReponsitory;

@Controller
@RequestMapping(value = "/statistic")
public class StatisticController {
	@Autowired
	private BillReponsitory billReponsitory;

	@RequestMapping(value = { "", "/index" })
	public String getListProduct(Model model) {
		List<Bill> products;
		int tt = 0;
		int stt = 0;
		products = billReponsitory.findAll();
		for (Bill bill : products) {
			tt += bill.getMaThongTin().getGiaVe();
		}
		model.addAttribute("pros", products);
		model.addAttribute("stt", stt);
		model.addAttribute("tt", tt);
		return "admin/statistic/statisticIndex";
	}

	@GetMapping(value = "/initInsert")
	public String add(Model model) {
		TicketDetail m = new TicketDetail();
		model.addAttribute("m", m);
		return "admin/ticketdetail/addTicketDetail";
	}

	@PostMapping(value = "/insert")
	public String insert(@Valid @ModelAttribute("m") Bill m, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("m", m);
			return "admin/ticketdetail/addTicketDetail";
		} else {
			boolean bl = billReponsitory.add(m);
			if (bl) {
				return "redirect:/ticketdetail/index";
			} else {
				model.addAttribute("m", m);
				model.addAttribute("err", "Thêm Mới Không Thành Công");
				return "admin/ticketdetail/addTicketDetail";
			}
		}
	}

	@GetMapping(value = "/preUpdate")
	public String preUpdate(@RequestParam("id") Integer id, Model model) {
		Bill m = billReponsitory.getById(id);
		model.addAttribute("m", m);
		return "admin/ticketdetail/updateTicketDetail";
	}

	@PostMapping(value = "/update")
	public String update(@ModelAttribute("m") Bill m, Model model) {
		boolean bl = billReponsitory.edit(m);
		if (bl) {
			model.addAttribute("err", "Cập Nhật Thành Công");
			return "redirect:/ticketdetail/index";
		} else {
			model.addAttribute("m", m);
			model.addAttribute("err", "Cập Nhật Không Thành Công");
			return "admin/ticketdetail/updateTicketDetail";
		}
	}

	@RequestMapping(value = "/delete")
	public String xoa(@RequestParam("id") Integer id, Model model) {
		billReponsitory.delete(id);
		return "redirect:/ticketdetail/index";
	}
}
