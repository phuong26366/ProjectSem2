package com.controller.flight;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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
import com.model.Flight;
import com.model.Airstrip;
import com.model.Airline;
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
		List<Flight> products;
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
		Flight c = new Flight();
		List<Airline> m = mayBayReponsitory.findAll();
		List<Airstrip> d = duongBayReponsitory.findAll();
		model.addAttribute("m", m);
		model.addAttribute("c", c);
		model.addAttribute("d", d);
		return "admin/flight/addFlight";
	}

	@PostMapping(value = "/insert")
	public String insert(@Valid @ModelAttribute("c") Flight c, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			List<Airline> m = mayBayReponsitory.findAll();
			List<Airstrip> d = duongBayReponsitory.findAll();
			model.addAttribute("m", m);
			model.addAttribute("d", d);
			model.addAttribute("c", c);
			return "admin/flight/addFlight";
		} else {
			List<Flight> chuyenbays = chyenBayReponsitory.findAll();
			for (Flight chuyenbay : chuyenbays) {
				if (c.getNgayBay().equals(chuyenbay.getNgayBay()) == true
						& c.getGioBay().equalsIgnoreCase(chuyenbay.getGioBay()) == true
						& c.getMaMayBay().equals(chuyenbay.getMaMayBay()) == true) {
					model.addAttribute("err", "Máy bay đã được sử dụng !");
					List<Airline> m = mayBayReponsitory.findAll();
					List<Airstrip> d = duongBayReponsitory.findAll();
					model.addAttribute("m", m);
					model.addAttribute("d", d);
					return "admin/flight/addFlight";
				}
				if (c.getGioBay().equalsIgnoreCase(chuyenbay.getGioBay()) == true
						&& c.getTenChuyenBay().equalsIgnoreCase(chuyenbay.getTenChuyenBay()) == true
						&& c.getNgayBay().equals(chuyenbay.getNgayBay()) == true) {
					model.addAttribute("err", "Chuyến bay đã tồn tại !");
					List<Airline> m = mayBayReponsitory.findAll();
					List<Airstrip> d = duongBayReponsitory.findAll();
					model.addAttribute("m", m);
					model.addAttribute("d", d);
					return "admin/flight/addFlight";
				}
				if (c.getNgayBay().equals(chuyenbay.getNgayBay()) == true
						& c.getGioBay().equalsIgnoreCase(chuyenbay.getGioBay()) == true
						& c.getMaDuongBay().equals(chuyenbay.getMaDuongBay()) == true) {
					model.addAttribute("err", "Đường bay đã được sử dụng !");
					List<Airline> m = mayBayReponsitory.findAll();
					List<Airstrip> d = duongBayReponsitory.findAll();
					model.addAttribute("m", m);
					model.addAttribute("d", d);
					return "admin/flight/addFlight";
				}
			}
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
		Flight c = chyenBayReponsitory.getById(id);
		List<Airline> m = mayBayReponsitory.findAll();
		List<Airstrip> d = duongBayReponsitory.findAll();
		model.addAttribute("c", c);
		model.addAttribute("m", m);
		model.addAttribute("d", d);
		return "admin/flight/updateFlight";
	}

	@PostMapping(value = "/update")
	public String update(@Valid @ModelAttribute("c") Flight c,BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			List<Airline> m = mayBayReponsitory.findAll();
			List<Airstrip> d = duongBayReponsitory.findAll();
			model.addAttribute("m", m);
			model.addAttribute("c", c);
			model.addAttribute("d", d);
			return "admin/flight/updateFlight";
		}
		boolean bl = chyenBayReponsitory.edit(c);
		if (bl) {
			model.addAttribute("err", "Cập Nhật Thành Công");
			return "redirect:/flight/index";
		} else {
			List<Airline> m = mayBayReponsitory.findAll();
			List<Airstrip> d = duongBayReponsitory.findAll();
			model.addAttribute("m", m);
			model.addAttribute("c", c);
			model.addAttribute("d", d);
			model.addAttribute("err", "Cập Nhật Không Thành Công");
			return "admin/flight/updateFlight";
		}
	}

	@RequestMapping(value = "/delete")
	public String xoa(@RequestParam("id") Integer id, Model model) {
		chyenBayReponsitory.delete(id);
		return "redirect:/flight/index";
	}
}
