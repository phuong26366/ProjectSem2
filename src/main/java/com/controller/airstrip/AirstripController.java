package com.controller.airstrip;

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
import com.model.DuongBay;
import com.reponsitory.DaoReponsitory;

@Controller
@RequestMapping(value = "/airstrip")
public class AirstripController {
	@Autowired
	private DaoReponsitory<DuongBay, Integer> airstripReponsitory;

	@RequestMapping(value = { "", "/index" })
	public String getListProduct(Model model,
			@RequestParam(value = "page", required = false, defaultValue = "1") int page,
			@RequestParam(value = "name", required = false, defaultValue = "") String name) {
		int pageSize = 3;
		int firstResult = (page - 1) * pageSize;
		List<DuongBay> products;
		Long totalRecords;
		if (name == "") {
			totalRecords = airstripReponsitory.countTotalRecords(null);
			products = airstripReponsitory.findAll(firstResult, pageSize);
		} else {
			totalRecords = airstripReponsitory.countTotalRecords(name);
			products = airstripReponsitory.findAll(firstResult, pageSize, name);
		}

		model.addAttribute("pros", products);
		model.addAttribute("pageSize", pageSize);
		model.addAttribute("totalRecords", totalRecords);
		model.addAttribute("page", page);
		model.addAttribute("name", name);
		return "admin/airstrip/airstripIndex";
	}

	@GetMapping(value = "/initInsert")
	public String add(Model model) {
		DuongBay m = new DuongBay();
		model.addAttribute("m", m);
		return "admin/airstrip/addAirstrip";
	}

	@PostMapping(value = "/insert")
	public String insert(@Valid @ModelAttribute("m") DuongBay m, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("m", m);
			return "admin/airstrip/addAirstrip";
		} else {
			boolean bl = airstripReponsitory.add(m);
			if (bl) {
				return "redirect:/airstrip/index";
			} else {
				model.addAttribute("m", m);
				model.addAttribute("err", "Thêm Mới Không Thành Công");
				return "admin/airstrip/airstripIndex";
			}
		}
	}
	@GetMapping(value = "/preUpdate")
	public String preUpdate(@RequestParam("id") Integer id, Model model) {
		DuongBay  m = airstripReponsitory.getById(id);
		model.addAttribute("m", m);
		return "admin/airstrip/updateAirstrip";
	}
	@PostMapping(value = "/update")
	public String update(@ModelAttribute("m") DuongBay m, Model model) {
		boolean bl = airstripReponsitory.edit(m);
		if (bl) {
			model.addAttribute("err", "Cập Nhật Thành Công");
			return "redirect:/airstrip/index";
		} else {
			model.addAttribute("m", m);
			model.addAttribute("err", "Cập Nhật Không Thành Công");
			return "admin/airstrip/updateAirstrip";
		}
	}
	@RequestMapping(value = "/delete")
	public String xoa(@RequestParam("id") Integer id, Model model) {
		airstripReponsitory.delete(id);
		return "redirect:/airstrip/index";
	}
}
