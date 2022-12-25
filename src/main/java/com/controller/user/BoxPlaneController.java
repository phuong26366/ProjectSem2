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

import com.model.ChuyenBay;

import com.reponsitory.AirstripReponsitory;
import com.reponsitory.FlightReponsitory;

@Controller
@RequestMapping(value = "/box-plane")
public class BoxPlaneController {
	@Autowired
	private FlightReponsitory flightReponsitory;

	@RequestMapping(value = { "", "/index" })
	public String getListProduct(Model model) {
		return "admin/datVeMayBay/searchFlight";
	}

	@PostMapping(value = "/search")
	public String getListProduct(Model model,
			@RequestParam(value = "page", required = false, defaultValue = "1") int page,
			@RequestParam(value = "diemDi", required = false, defaultValue = "") String diemDi,
			@RequestParam(value = "diemDen", required = false, defaultValue = "") String diemDen,
			@RequestParam(value = "date", required = false, defaultValue = "") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date ) {
		int pageSize = 3;
		int firstResult = (page - 1) * pageSize;
		List<ChuyenBay> products;
		Long totalRecords;
//		if (name == "") {
//			totalRecords = chyenBayReponsitory.countTotalRecords(null);
//			products = chyenBayReponsitory.findAll(firstResult, pageSize);
//		} else {
//			totalRecords = chyenBayReponsitory.countTotalRecords(name);
//			products = chyenBayReponsitory.findAll(firstResult, pageSize, name);
//		}
		products = flightReponsitory.findAll(firstResult, pageSize, diemDi, diemDen, date);
		model.addAttribute("pros", products);
		model.addAttribute("pageSize", pageSize);
//		model.addAttribute("totalRecords", totalRecords);
		model.addAttribute("page", page);
//		model.addAttribute("name", name);
		return "admin/datVeMayBay/listSearchFlight";
	}

//	@PostMapping(value = "/insert")
//	public String insert(@Valid @ModelAttribute("m") DuongBay m, BindingResult bindingResult, Model model) {
//		if (bindingResult.hasErrors()) {
//			model.addAttribute("m", m);
//			return "admin/airstrip/addAirstrip";
//		} else {
//			List<DuongBay> duongBay = airstripReponsitory.findAll();
//			for (DuongBay duongBay1 : duongBay) {
//				if (m.getTenDuongBay().equalsIgnoreCase(duongBay1.getTenDuongBay()) == true) {
//					model.addAttribute("err", "Tên máy bay đã tồn tại");
//					return "admin/maybay/addMayBay";
//				}
//			}
//			boolean bl = airstripReponsitory.add(m);
//			if (bl) {
//				return "redirect:/airstrip/index";
//			} else {
//				model.addAttribute("m", m);
//				model.addAttribute("err", "Thêm Mới Không Thành Công");
//				return "admin/airstrip/airstripIndex";
//			}
//		}
//	}
//
//	@GetMapping(value = "/preUpdate")
//	public String preUpdate(@RequestParam("id") Integer id, Model model) {
//		DuongBay m = airstripReponsitory.getById(id);
//		model.addAttribute("m", m);
//		return "admin/airstrip/updateAirstrip";
//	}
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
