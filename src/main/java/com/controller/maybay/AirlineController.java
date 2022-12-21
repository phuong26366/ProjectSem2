package com.controller.maybay;

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
import com.model.MayBay;
import com.reponsitory.AirlineReponsitory;

@Controller
@RequestMapping(value = "/maybay")
public class AirlineController {

	@Autowired
	private AirlineReponsitory mayBayReponsitory;

	@RequestMapping(value = { "", "/index" })
	public String getListProduct(Model model,
			@RequestParam(value = "page", required = false, defaultValue = "1") int page,
			@RequestParam(value = "name", required = false, defaultValue = "") String name) {
		int pageSize = 3;
		int firstResult = (page - 1) * pageSize;
		List<MayBay> products;
		Long totalRecords;
		if (name == "") {
			totalRecords = mayBayReponsitory.countTotalRecords(null);
			products = mayBayReponsitory.findAll(firstResult, pageSize);
		} else {
			totalRecords = mayBayReponsitory.countTotalRecords(name);
			products = mayBayReponsitory.findAll(firstResult, pageSize, name);
		}

		model.addAttribute("pros", products);
		model.addAttribute("pageSize", pageSize);
		model.addAttribute("totalRecords", totalRecords);
		model.addAttribute("page", page);
		model.addAttribute("name", name);
		return "admin/maybay/airlineIndex";
	}

	@GetMapping(value = "/initInsert")
	public String add(Model model) {
		MayBay m = new MayBay();
		model.addAttribute("m", m);
		return "admin/maybay/addMayBay";
	}

	@PostMapping(value = "/insert")
	public String insert(@Valid @ModelAttribute("m") MayBay m, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("m", m);
			return "admin/maybay/addMayBay";
		} else {
			List<MayBay> mayBay = mayBayReponsitory.findAll();
			for (MayBay mayBay2 : mayBay) {
				if (m.getTenMayBay().equalsIgnoreCase(mayBay2.getTenMayBay()) == true) {
					model.addAttribute("err", "Tên máy bay đã tồn tại");
					return "admin/maybay/addMayBay";
				}
			}
			boolean bl = mayBayReponsitory.add(m);
			if (bl) {
				return "redirect:/maybay/index";
			} else {
				model.addAttribute("m", m);
				model.addAttribute("err", "Thêm Mới Không Thành Công");
				return "admin/maybay/addMayBay";
			}
		}
	}
	@GetMapping(value = "/preUpdate")
	public String preUpdate(@RequestParam("id") Integer id, Model model) {
		MayBay m = mayBayReponsitory.getById(id);
		model.addAttribute("m", m);
		return "admin/maybay/updateAirline";
	}
	@PostMapping(value = "/update")
	public String update(@ModelAttribute("m") MayBay m, Model model) {
		boolean bl = mayBayReponsitory.edit(m);
		if (bl) {
			model.addAttribute("err", "Cập Nhật Thành Công");
			return "redirect:/maybay/index";
		} else {
			model.addAttribute("m", m);
			model.addAttribute("err", "Cập Nhật Không Thành Công");
			return "admin/maybay/updateAirline";
		}
	}
	@RequestMapping(value = "/delete")
	public String xoa(@RequestParam("id") Integer id, Model model) {
		mayBayReponsitory.delete(id);
		return "redirect:/maybay/index";
	}
}
