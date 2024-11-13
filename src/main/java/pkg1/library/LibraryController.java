package pkg1.library;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/library")
public class LibraryController {
	@Autowired
	LibraryRepo lr;
	
	@PostMapping("/books/add")
	public LibraryEntity addBook(@RequestBody LibraryEntity le) {
		return lr.save(le);
	}
	@GetMapping("/books/get/all")
	public List<LibraryEntity> getAllBooks(){
		return lr.findAll();
	}
}
