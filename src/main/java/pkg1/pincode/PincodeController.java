package pkg1.pincode;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PincodeController {
	@Autowired
	PincodeRepo pr;
	
	@PostMapping("/pincode/add")
	public PincodeEntity addPincode(@RequestBody PincodeEntity pe) {
		return pr.save(pe);
	}
	
	@GetMapping("/pincode/getAll")
	public List<PincodeEntity> getAllPincode(){
		return pr.findAll();
	}
	
	@GetMapping("/pincode/get/by/pincode/{pincode}")
	public Optional<PincodeEntity> getPincodeByPincode(@PathVariable int pincode){
		return pr.findPincodeByPincode(pincode);
	}
}
