package pkg1.pincode;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class PincodeController {
	
	private static final String location = "uploads/";
	
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
	
	@PostMapping("/upload")
    public ResponseEntity<String>  uploadFile(@RequestParam MultipartFile mpf) {
        if (mpf.isEmpty()) {
            return new ResponseEntity("Please select a file to upload.", HttpStatus.BAD_REQUEST);
        }

        try {
            // Create the directory if it does not exist
            File dir = new File(location);
            if (!dir.exists()) {
                dir.mkdirs();
            }
            byte[] bytes = mpf.getBytes();
            // Save the file to the target location
            Path path = Paths.get(location+mpf.getOriginalFilename());
            Files.write(path, bytes);
            String fname=location+"/"+mpf.getOriginalFilename();
    		File f1=new File(fname);
    		Scanner sc1=new Scanner(f1);
    		while(sc1.hasNext()) {
    			String line1= sc1.nextLine();
    			String[] arr1 = line1.split(",");
    			int pincode = Integer.valueOf(arr1[0]);
    			String location = arr1[1];
    			String town = arr1[2];
    			String district = arr1[3];
    			String state = arr1[4];
    			PincodeEntity savePincodes=new PincodeEntity();
    			savePincodes.setPincode(pincode);
    			savePincodes.setLocation(location);
    			savePincodes.setTown(town);
    			savePincodes.setDistrict(district);
    			savePincodes.setState(state);
    			pr.save(savePincodes);
    		}
            return new ResponseEntity<>("File uploaded successfully: " + mpf.getOriginalFilename(), HttpStatus.OK);

        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>("Failed to upload file.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
	
//	@PostMapping("/upload")
//    public String uploadFile(@RequestParam MultipartFile mpf) {
//        if (mpf.isEmpty()) {
//            return "Please select a file to upload";
//        }
//
//        try {
//            // Create the directory if it does not exist
//            File dir = new File(location);
//            if (!dir.exists()) {
//                dir.mkdirs();
//            }
//            byte[] bytes = mpf.getBytes();
//            // Save the file to the target location
//            Path path = Paths.get(location+mpf.getOriginalFilename());
//            Files.write(path, bytes);
//            String location="uploads/";
//    		File f1=new File(location+"/"+fname);
//    		Scanner sc1=new Scanner(f1);
//            return "Uploaded Successfully to: " + ;
//
//        } catch (IOException e) {
//            e.printStackTrace();
//            return "File upload failed: " + e.getMessage();
//        }
//    }
}
