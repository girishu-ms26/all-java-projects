package com.emedicare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.emedicare.entity.EMedicines;
import com.emedicare.service.EmedicineService;

@Controller
@RequestMapping("/medicines")
public class MedicineController {
	
	@Autowired
	private EmedicineService emedicineService;	
	
	@GetMapping("/medicinelist")
	public String medicinelist(Model theModel) {
		List<EMedicines> eMedicines = emedicineService.getEMedicines();
		theModel.addAttribute("medicines", eMedicines);
		return "medicine-list";
	}
	
	@GetMapping("/medicineforUser")
	public String medicinelistforusers(Model theModel) {
		List<EMedicines> eMedicines = emedicineService.getEMedicines();
		theModel.addAttribute("medicines", eMedicines);
		return "medicinesforusers";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("medicineid") int id) {
		emedicineService.deletebyId(id);
		return "redirect:/medicines/medicinelist";
	}
	
	@GetMapping("/update")
	public String update(@RequestParam("medicineid") int medicineid,Model theModel) {
		EMedicines themedicine = emedicineService.getMedicine(medicineid);
		theModel.addAttribute("medicine", themedicine);
		return "medicineupdate";
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute("EMedicines") EMedicines medicine) {
		emedicineService.saveMedicine(medicine);
		return "redirect:/medicines/medicinelist";
	}
}
