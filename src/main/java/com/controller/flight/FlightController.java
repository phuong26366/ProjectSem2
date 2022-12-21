package com.controller.flight;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.model.ChuyenBay;
import com.model.DuongBay;
import com.model.MayBay;
import com.reponsitory.AirlineReponsitory;
import com.reponsitory.AirstripReponsitory;
import com.reponsitory.FlightReponsitory;

@Controller
@RequestMapping(value = "/flight")
public class FlightController {

	@Autowired
	private AirlineReponsitory mayBayReponsitory;
	@Autowired
	private FlightReponsitory chyenBayReponsitory;
	@Autowired
	private AirstripReponsitory duongBayReponsitory;

	@InitBinder
	public void initBinder(WebDataBinder data) {
		SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
		s.setLenient(false);
		data.registerCustomEditor(Date.class, new CustomDateEditor(s, true));
	}

	@RequestMapping(value = { "", "/index" })
	public String getListProduct(Model model,
			@RequestParam(value = "page", required = false, defaultValue = "1") int page,
			@RequestParam(value = "name", required = false, defaultValue = "") String name) {
		int pageSize = 3;
		int firstResult = (page - 1) * pageSize;
		List<ChuyenBay> products;
		Long totalRecords;
		if (name == "") {
			totalRecords = chyenBayReponsitory.countTotalRecords(null);
			products = chyenBayReponsitory.findAll(firstResult, pageSize);
		} else {
			totalRecords = chyenBayReponsitory.countTotalRecords(name);
			products = chyenBayReponsitory.findAll(firstResult, pageSize, name);
		}

		model.addAttribute("pros", products);
		model.addAttribute("pageSize", pageSize);
		model.addAttribute("totalRecords", totalRecords);
		model.addAttribute("page", page);
		model.addAttribute("name", name);
		return "admin/flight/flightIndex";
	}

	@GetMapping(value = "/initInsert")
	public String add(Model model) {
		ChuyenBay c = new ChuyenBay();
		List<MayBay> m = mayBayReponsitory.findAll();
		List<DuongBay> d = duongBayReponsitory.findAll();
		model.addAttribute("m", m);
		model.addAttribute("c", c);
		model.addAttribute("d", d);
		return "admin/flight/addFlight";
	}

	@PostMapping(value = "/insert")
	public String insert(@Valid @ModelAttribute("c") ChuyenBay c, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			List<MayBay> m = mayBayReponsitory.findAll();
			List<DuongBay> d = duongBayReponsitory.findAll();
			model.addAttribute("m", m);
			model.addAttribute("c", c);
			model.addAttribute("d", d);
			return "admin/flight/addFlight";
		} else {
			boolean bl = chyenBayReponsitory.add(c);
			if (bl) {
				return "redirect:/flight/index";
			} else {
				model.addAttribute("c", c);
				model.addAttribute("err", "Thêm Mới Không Thành Công");
				return "admin/flight/addFlight";
			}
		}
	}

	@GetMapping(value = "/preUpdate")
	public String preUpdate(@RequestParam("id") Integer id, Model model) {
		ChuyenBay c = chyenBayReponsitory.getById(id);
		List<MayBay> m = mayBayReponsitory.findAll();
		List<DuongBay> d = duongBayReponsitory.findAll();
		model.addAttribute("c", c);
		model.addAttribute("m", m);
		model.addAttribute("d", d);
		return "admin/flight/updateFlight";
	}

	@PostMapping(value = "/update")
	public String update(@ModelAttribute("c") ChuyenBay c, Model model) {
		boolean bl = chyenBayReponsitory.edit(c);
		if (bl) {
			model.addAttribute("err", "Cập Nhật Thành Công");
			return "redirect:/flight/index";
		} else {
			model.addAttribute("c", c);
			List<MayBay> m = mayBayReponsitory.findAll();
			List<DuongBay> d = duongBayReponsitory.findAll();
			model.addAttribute("m", m);
			model.addAttribute("c", c);
			model.addAttribute("d", d);
			model.addAttribute("err", "Cập Nhật Không Thành Công");
			return "admin/flight/updateFlight";
		}
	}

	@RequestMapping(value = "/delete")
	public String xoa(@RequestParam("id") Integer id, Model model) {
		mayBayReponsitory.delete(id);
		return "redirect:/flight/index";
	}
}
