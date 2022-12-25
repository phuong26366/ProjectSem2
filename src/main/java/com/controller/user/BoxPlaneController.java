package com.controller.user;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.model.Bill;
import com.model.ChuyenBay;
import com.model.Customer;
import com.model.DuongBay;
import com.model.TicketDetail;
import com.reponsitory.BillReponsitory;
import com.reponsitory.CustomerReponsitory;
import com.reponsitory.FlightReponsitory;
import com.reponsitory.TicketDetailReponsitory;

@Controller
@RequestMapping(value = "/box-plane")
public class BoxPlaneController {
	@Autowired
	private FlightReponsitory flightReponsitory;
	@Autowired
	private TicketDetailReponsitory ticketDetailReponsitory;

	@Autowired
	private CustomerReponsitory customerReponsitory;
	@Autowired
	private BillReponsitory billReponsitory;

	@RequestMapping(value = { "", "/index" })
	public String getListProduct(Model model) {
		return "admin/datVeMayBay/searchFlight";
	}

	@PostMapping(value = "/search")
	public String getListProduct(Model model,
			@RequestParam(value = "page", required = false, defaultValue = "1") int page,
			@RequestParam(value = "diemDi", required = false, defaultValue = "") String diemDi,
			@RequestParam(value = "diemDen", required = false, defaultValue = "") String diemDen,
			@RequestParam(value = "date", required = false, defaultValue = "") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {
		int pageSize = 3;
		int firstResult = (page - 1) * pageSize;
		List<ChuyenBay> products;
		Long totalRecords;
		products = flightReponsitory.findAll(firstResult, pageSize, diemDi, diemDen, date);
		model.addAttribute("pros", products);
		model.addAttribute("pageSize", pageSize);
		model.addAttribute("page", page);
		return "admin/datVeMayBay/listSearchFlight";
	}

	@GetMapping(value = "/initBill")
	public String preUpdate(@RequestParam("id") Integer id, Model model) {
		Customer m = new Customer();
		ChuyenBay c = flightReponsitory.getById(id);
		List<TicketDetail> list = ticketDetailReponsitory.findAll(c);
		model.addAttribute("c", c);
		model.addAttribute("m", m);
		model.addAttribute("list", list);
		return "admin/datVeMayBay/addNewBill";
	}

	@PostMapping(value = "/insert")
	public String insert(@Valid @ModelAttribute("m") Customer m, BindingResult bindingResult,
			@RequestParam(value = "maThongTin", required = false) Integer maThongTin,
			@RequestParam(value = "id", required = false) Integer maChuyenBay, Model model) {
		System.out.println(maChuyenBay);
		if (bindingResult.hasErrors()) {
			model.addAttribute("m", m);
			ChuyenBay c = flightReponsitory.getById(maChuyenBay);
			List<TicketDetail> list = ticketDetailReponsitory.findAll(c);
			model.addAttribute("c", c);
			model.addAttribute("m", m);
			model.addAttribute("list", list);
			return "admin/datVeMayBay/addNewBill";
		} else {
			Boolean bl = customerReponsitory.add(m);
			if (bl) {
				Bill b = new Bill();
				ChuyenBay c = flightReponsitory.getById(maChuyenBay);
				TicketDetail t = ticketDetailReponsitory.getById(maThongTin);
				b.setMaChuyenBays(c);
				b.setMaThongTin(t);
				b.setMaKhachHang(m);
				b.settGlap(new Date());
				billReponsitory.add(b);
				return "admin/datVeMayBay/searchFlight";
			} else {
				ChuyenBay c = flightReponsitory.getById(maChuyenBay);
				List<TicketDetail> list = ticketDetailReponsitory.findAll(c);
				model.addAttribute("c", c);
				model.addAttribute("m", m);
				model.addAttribute("list", list);
				return "admin/datVeMayBay/addNewBill";
			}

		}
	}

//
//	@PostMapping(value = "/update")
//	public String update(@ModelAttribute("m") DuongBay m, Model model) {
//		boolean bl = airstripReponsitory.edit(m);
//		if (bl) {
//			model.addAttribute("err", "Cập Nhật Thành Công");
//			return "redirect:/airstrip/index";
//		} else {
//			model.addAttribute("m", m);
//			model.addAttribute("err", "Cập Nhật Không Thành Công");
//			return "admin/airstrip/updateAirstrip";
//		}
//	}
//
//	@RequestMapping(value = "/delete")
//	public String xoa(@RequestParam("id") Integer id, Model model) {
//		airstripReponsitory.delete(id);
//		return "redirect:/airstrip/index";
//	}
}
