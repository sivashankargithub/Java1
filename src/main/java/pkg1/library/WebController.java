package pkg1.library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {
	@Autowired
	LibraryRepo lr;
	
	@GetMapping("/web/books/get")
	public String displayBooks(Model model) {
		LibraryEntity le =lr.findAll().get(0); 
		model.addAttribute("name",le.getBookName());
		model.addAttribute("publisher",le.getPublisher());
		return "library";
	}
}
