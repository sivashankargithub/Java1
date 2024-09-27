package pkg1.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pkg1.pincode.PincodeEntity;
import pkg1.pincode.PincodeRepo;

@Controller
@RequestMapping("/pincode")
public class InputPageController {
	@Autowired
	PincodeRepo pr;
	
	@GetMapping("/insert")
	public String getInput() {
		return "index1";
	}
	
	@PostMapping("/details")
	public String displayMsg(@ModelAttribute PincodeEntity pe, Model model) {
		pr.save(pe);
		model.addAttribute("pin",pe.getPincode());
		model.addAttribute("msg","Inserted Successfully");
		return "index2";
	}
	
}
