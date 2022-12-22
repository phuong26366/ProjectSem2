package com.controller.customer;

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
import com.model.Customer;
import com.reponsitory.CustomerReponsitory;

@Controller
@RequestMapping(value = "/customer")
public class CustomerController {
	@Autowired
	private CustomerReponsitory customerReponsitory;

	@RequestMapping(value = { "", "/index" })
	public String getListProduct(Model model,
			@RequestParam(value = "page", required = false, defaultValue = "1") int page,
			@RequestParam(value = "name", required = false, defaultValue = "") String name) {
		int pageSize = 3;
		int firstResult = (page - 1) * pageSize;
		List<Customer> products;
		Long totalRecords;
		if (name == "") {
			totalRecords = customerReponsitory.countTotalRecords(null);
			products = customerReponsitory.findAll(firstResult, pageSize);
		} else {
			totalRecords = customerReponsitory.countTotalRecords(name);
			products = customerReponsitory.findAll(firstResult, pageSize, name);
		}

		model.addAttribute("pros", products);
		model.addAttribute("pageSize", pageSize);
		model.addAttribute("totalRecords", totalRecords);
		model.addAttribute("page", page);
		model.addAttribute("name", name);
		return "admin/customer/customerIndex";
	}

	@GetMapping(value = "/initInsert")
	public String add(Model model) {
		Customer m = new Customer();
		model.addAttribute("m", m);
		return "admin/datVeMayBay/datVeMayBay";
	}

	@PostMapping(value = "/insert")
	public String insert(@Valid @ModelAttribute("m") Customer m, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("m", m);
			return "admin/datVeMayBay/datVeMayBay";
		} else {
			boolean bl = customerReponsitory.add(m);
			if (bl) {
				return "redirect:/customer/index";
			} else {
				model.addAttribute("m", m);
				model.addAttribute("err", "Thêm Mới Không Thành Công");
				return "admin/datVeMayBay/datVeMayBay";
			}
		}
	}

	@GetMapping(value = "/preUpdate")
	public String preUpdate(@RequestParam("id") Integer id, Model model) {
		Customer m = customerReponsitory.getById(id);
		model.addAttribute("m", m);
		return "admin/customer/updateCustomer";
	}

	@PostMapping(value = "/update")
	public String update(@ModelAttribute("m") Customer m, Model model) {
		boolean bl = customerReponsitory.edit(m);
		if (bl) {
			model.addAttribute("err", "Cập Nhật Thành Công");
			return "redirect:/customer/index";
		} else {
			model.addAttribute("m", m);
			model.addAttribute("err", "Cập Nhật Không Thành Công");
			return "admin/customer/updateCustomer";
		}
	}

	@RequestMapping(value = "/delete")
	public String xoa(@RequestParam("id") Integer id, Model model) {
		customerReponsitory.delete(id);
		return "redirect:/customer/index";
	}
}
