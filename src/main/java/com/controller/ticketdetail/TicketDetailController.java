package com.controller.ticketdetail;

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
import com.model.ChuyenBay;
import com.model.TicketDetail;
import com.reponsitory.FlightReponsitory;
import com.reponsitory.TicketDetailReponsitory;

@Controller
@RequestMapping(value = "/ticketdetail")
public class TicketDetailController {
	@Autowired
	private TicketDetailReponsitory ticketDetailReponsitory;
	@Autowired
	private FlightReponsitory chyenBayReponsitory;

	@RequestMapping(value = { "", "/index" })
	public String getListProduct(Model model,
			@RequestParam(value = "page", required = false, defaultValue = "1") int page,
			@RequestParam(value = "name", required = false, defaultValue = "") String name) {
		int pageSize = 3;
		int firstResult = (page - 1) * pageSize;
		List<TicketDetail> products;
		Long totalRecords;
		products = ticketDetailReponsitory.findAll();
		totalRecords = ticketDetailReponsitory.countTotalRecords();
		model.addAttribute("pros", products);
		model.addAttribute("pageSize", pageSize);
		model.addAttribute("totalRecords", totalRecords);
		model.addAttribute("page", page);
		model.addAttribute("name", name);
		return "admin/ticketdetail/ticketDetailIndex";
	}

	@GetMapping(value = "/initInsert")
	public String add(Model model) {
		TicketDetail m = new TicketDetail();
		List<ChuyenBay> chuyenBays = chyenBayReponsitory.findAll();
		model.addAttribute("m", m);
		model.addAttribute("chuyenBays", chuyenBays);
		return "admin/ticketdetail/addTicketDetail";
	}

	@PostMapping(value = "/insert")
	public String insert(@Valid @ModelAttribute("m") TicketDetail m, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			List<ChuyenBay> chuyenBays = chyenBayReponsitory.findAll();
			model.addAttribute("m", m);
			model.addAttribute("chuyenBays", chuyenBays);
			return "admin/ticketdetail/addTicketDetail";
		} else {
			boolean bl = ticketDetailReponsitory.add(m);
			if (bl) {
				return "redirect:/ticketdetail/index";
			} else {
				List<ChuyenBay> chuyenBays = chyenBayReponsitory.findAll();
				model.addAttribute("m", m);
				model.addAttribute("chuyenBays", chuyenBays);
				model.addAttribute("err", "Thêm Mới Không Thành Công");
				return "admin/ticketdetail/addTicketDetail";
			}
		}
	}

	@GetMapping(value = "/preUpdate")
	public String preUpdate(@RequestParam("id") Integer id, Model model) {
		TicketDetail m = ticketDetailReponsitory.getById(id);
		List<ChuyenBay> chuyenBays = chyenBayReponsitory.findAll();
		model.addAttribute("m", m);
		model.addAttribute("chuyenBays", chuyenBays);
		return "admin/ticketdetail/updateTicketDetail";
	}

	@PostMapping(value = "/update")
	public String update(@ModelAttribute("m") TicketDetail m, Model model) {
		boolean bl = ticketDetailReponsitory.edit(m);
		if (bl) {
			model.addAttribute("err", "Cập Nhật Thành Công");
			return "redirect:/ticketdetail/index";
		} else {
			List<ChuyenBay> chuyenBays = chyenBayReponsitory.findAll();
			model.addAttribute("m", m);
			model.addAttribute("chuyenBays", chuyenBays);
			model.addAttribute("err", "Cập Nhật Không Thành Công");
			return "admin/ticketdetail/updateTicketDetail";
		}
	}

	@RequestMapping(value = "/delete")
	public String xoa(@RequestParam("id") Integer id, Model model) {
		ticketDetailReponsitory.delete(id);
		return "redirect:/ticketdetail/index";	
	}
}
