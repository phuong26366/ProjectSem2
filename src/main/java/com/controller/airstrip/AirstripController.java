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
import com.model.Airstrip;
import com.reponsitory.AirstripReponsitory;

@Controller
@RequestMapping(value = "/airstrip")
public class AirstripController {
	@Autowired
	private AirstripReponsitory airstripReponsitory;

	@RequestMapping(value = { "", "/index" })
	public String getListProduct(Model model,
			@RequestParam(value = "page", required = false, defaultValue = "1") int page,
			@RequestParam(value = "name", required = false, defaultValue = "") String name) {
		int pageSize = 3;
		int firstResult = (page - 1) * pageSize;
		List<Airstrip> products;
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
		Airstrip m = new Airstrip();
		model.addAttribute("m", m);
		return "admin/airstrip/addAirstrip";
	}

	@PostMapping(value = "/insert")
	public String insert(@Valid @ModelAttribute("m") Airstrip m, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("m", m);
			return "admin/airstrip/addAirstrip";
		} else {
			List<Airstrip> duongBay = airstripReponsitory.findAll();
			for (Airstrip duongBay1 : duongBay) {
				if (m.getTenDuongBay().equalsIgnoreCase(duongBay1.getTenDuongBay()) == true) {
					model.addAttribute("err", "T??n m??y bay ???? t???n t???i");
					return "admin/maybay/addMayBay";
				}
			}
			boolean bl = airstripReponsitory.add(m);
			if (bl) {
				return "redirect:/airstrip/index";
			} else {
				model.addAttribute("m", m);
				model.addAttribute("err", "Th??m M???i Kh??ng Th??nh C??ng");
				return "admin/airstrip/airstripIndex";
			}
		}
	}

	@GetMapping(value = "/preUpdate")
	public String preUpdate(@RequestParam("id") Integer id, Model model) {
		Airstrip m = airstripReponsitory.getById(id);
		model.addAttribute("m", m);
		return "admin/airstrip/updateAirstrip";
	}

	@PostMapping(value = "/update")
	public String update(@Valid @ModelAttribute("m") Airstrip m, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("m", m);
			return "admin/airstrip/updateAirstrip";
		}
		boolean bl = airstripReponsitory.edit(m);
		if (bl) {
			model.addAttribute("err", "C???p Nh???t Th??nh C??ng");
			return "redirect:/airstrip/index";
		} else {
			model.addAttribute("m", m);
			model.addAttribute("err", "C???p Nh???t Kh??ng Th??nh C??ng");
			return "admin/airstrip/updateAirstrip";
		}
	}

	@RequestMapping(value = "/delete")
	public String xoa(@RequestParam("id") Integer id, Model model) {
		airstripReponsitory.delete(id);
		return "redirect:/airstrip/index";
	}
}
