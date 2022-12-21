package com.controller.staff;

import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletContext;
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
import org.springframework.web.multipart.MultipartFile;

import com.model.Staff;
import com.reponsitory.AirlineReponsitory;
import com.reponsitory.StaffReponsitory;

@Controller
@RequestMapping(value = "/staff")
public class StaffController {

	@Autowired
	private StaffReponsitory staffReponsitory;
	@Autowired
	private ServletContext servletContext;

	@RequestMapping(value = { "", "/index" })
	public String getListProduct(Model model,
			@RequestParam(value = "page", required = false, defaultValue = "1") int page,
			@RequestParam(value = "name", required = false, defaultValue = "") String name) {
		int pageSize = 3;
		int firstResult = (page - 1) * pageSize;
		List<Staff> products;
		Long totalRecords;
		if (name == "") {
			totalRecords = staffReponsitory.countTotalRecords(null);
			products = staffReponsitory.findAll(firstResult, pageSize);
		} else {
			totalRecords = staffReponsitory.countTotalRecords(name);
			products = staffReponsitory.findAll(firstResult, pageSize, name);
		}

		model.addAttribute("pros", products);
		model.addAttribute("pageSize", pageSize);
		model.addAttribute("totalRecords", totalRecords);
		model.addAttribute("page", page);
		model.addAttribute("name", name);
		return "admin/staff/staffIndex";
	}

	@GetMapping(value = "/initInsert")
	public String add(Model model) {
		Staff s = new Staff();
		model.addAttribute("s", s);
		return "admin/staff/addStaff";
	}

	@PostMapping(value = "/insertStaff")
	public String insert(@Valid @ModelAttribute("s") Staff s, BindingResult bindingResult,Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("s", s);
			return "admin/staff/addStaff";
		} else {
			boolean bl = staffReponsitory.add(s);
			System.out.println(bl);
			if (bl) {
				model.addAttribute("err", "Add New Successful");
				return "redirect:/staff/index";
			} else {
				model.addAttribute("s", s);
				model.addAttribute("err", "Thêm mới không thành công");
				return "admin/staff/addStaff";
			}
//			if (upload != null || !upload.isEmpty()) {
//				String fileName = servletContext.getRealPath("/") + "resources\\images\\"
//						+ upload.getOriginalFilename();
//				m.setImage(upload.getOriginalFilename());
//				System.out.println(fileName);
//				try {
//					upload.transferTo(new File(fileName));
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
			
		}
	}

	@GetMapping(value = "/preUpdate")
	public String preUpdate(@RequestParam("id") Integer id, Model model) {
		Staff m = staffReponsitory.getById(id);
		model.addAttribute("m", m);
		return "admin/staff/updateStaff";
	}

	@PostMapping(value = "/update")
	public String update(@Valid @ModelAttribute("m") Staff m, BindingResult bindingResult,
			@RequestParam MultipartFile upload, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("m", m);
			return "admin/staff/updateStaff";
		} else {
			if (upload != null || !upload.isEmpty()) {

				String fileName = servletContext.getRealPath("/") + "resources\\images\\"
						+ upload.getOriginalFilename();
				m.setImage(upload.getOriginalFilename());
				try {
					upload.transferTo(new File(fileName));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			boolean bl = staffReponsitory.add(m);
			if (bl) {
				model.addAttribute("err", "Add New Successful");
				return "redirect:/staff/index";
			} else {
				model.addAttribute("m", m);
				model.addAttribute("err", "Cập nhật không thành công");
				return "admin/staff/updateStaff";
			}
		}
	}

	@RequestMapping(value = "/delete")
	public String xoa(@RequestParam("id") Integer id, Model model) {
		staffReponsitory.delete(id);
		return "redirect:/staff/index";
	}
}
