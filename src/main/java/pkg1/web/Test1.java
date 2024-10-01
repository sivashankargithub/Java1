package pkg1.web;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test1 {
	@GetMapping("/test/{fname}")
	public String printLine1(@PathVariable String fname) throws FileNotFoundException {
		String location="uploads/";
		File f1=new File(location+"/"+fname);
		Scanner sc1=new Scanner(f1);
		return sc1.nextLine();
	}
}
