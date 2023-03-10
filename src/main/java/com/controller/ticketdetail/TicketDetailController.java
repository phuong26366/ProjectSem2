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
import com.model.Flight;
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
		products = ticketDetailReponsitory.findAll(firstResult, pageSize);
		totalRecords = ticketDetailReponsitory.countTotalRecords(null);
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
		List<Flight> chuyenBays = chyenBayReponsitory.findAll();
		model.addAttribute("m", m);
		model.addAttribute("chuyenBays", chuyenBays);
		return "admin/ticketdetail/addTicketDetail";
	}

	@PostMapping(value = "/insert")
	public String insert(@Valid @ModelAttribute("m") TicketDetail m, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			List<Flight> chuyenBays = chyenBayReponsitory.findAll();
			model.addAttribute("m", m);
			model.addAttribute("chuyenBays", chuyenBays);
			return "admin/ticketdetail/addTicketDetail";
		} else {
			boolean bl = ticketDetailReponsitory.add(m);
			if (bl) {
				return "redirect:/ticketdetail/index";
			} else {
				List<Flight> chuyenBays = chyenBayReponsitory.findAll();
				model.addAttribute("m", m);
				model.addAttribute("chuyenBays", chuyenBays);
				model.addAttribute("err", "Th??m M???i Kh??ng Th??nh C??ng");
				return "admin/ticketdetail/addTicketDetail";
			}
		}
	}

	@GetMapping(value = "/preUpdate")
	public String preUpdate(@RequestParam("id") Integer id, Model model) {
		TicketDetail m = ticketDetailReponsitory.getById(id);
		List<Flight> chuyenBays = chyenBayReponsitory.findAll();
		model.addAttribute("m", m);
		model.addAttribute("chuyenBays", chuyenBays);
		return "admin/ticketdetail/updateTicketDetail";
	}

	@PostMapping(value = "/update")
	public String update(@Valid  @ModelAttribute("m") TicketDetail m,BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			List<Flight> chuyenBays = chyenBayReponsitory.findAll();
			model.addAttribute("m", m);
			model.addAttribute("chuyenBays", chuyenBays);
			return "admin/ticketdetail/updateTicketDetail";
		}
		boolean bl = ticketDetailReponsitory.edit(m);
		if (bl) {
			model.addAttribute("err", "C???p Nh???t Th??nh C??ng");
			return "redirect:/ticketdetail/index";
		} else {
			List<Flight> chuyenBays = chyenBayReponsitory.findAll();
			model.addAttribute("m", m);
			model.addAttribute("chuyenBays", chuyenBays);
			model.addAttribute("err", "C???p Nh???t Kh??ng Th??nh C??ng");
			return "admin/ticketdetail/updateTicketDetail";
		}
	}

	@RequestMapping(value = "/delete")
	public String xoa(@RequestParam("id") Integer id, Model model) {
		ticketDetailReponsitory.delete(id);
		return "redirect:/ticketdetail/index";
	}
}
