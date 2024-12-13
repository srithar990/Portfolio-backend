package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class AppController {
	@Autowired
	Service service;
	
	@Autowired
	JWTManager jwt;
	
	 @PostMapping("/insert")
	 public String insertPatents(@RequestBody Patents patents) {
	 	return service.insertPatents(patents);
	 }
	 
	 @GetMapping("/all")
	 public List<Patents> all(){
		 return service.all();
	 }
	 
	 @PostMapping("/userin")
		public String userInsert(@RequestBody User user) {
		 		user.setUpassword(jwt.encryptData(user.getUpassword())); 
				return service.insertUser(user);
		}
		
		@GetMapping("/user")
		public List<User> users(){
			return service.viewUser();
		}
		
		@PostMapping("/login")
		public Map<String, String> loginView(@RequestBody User user){
			user.setUpassword(jwt.encryptData(user.getUpassword()));
			return service.userAuth(user);
		}
	 
		
		//Its for Education
		 @PostMapping("/insert_education")
		 public String insertEducation(@RequestBody Education education) {
		 	return service.insertEducation(education);
		 }
		 
		 @GetMapping("/edu1")
		 public List<Education> edu1(@RequestParam("token") String token){
			 if( jwt.validateToken(token).get("username").equals("srithar") || jwt.validateToken(token).get("username").equals("admin"))
			 return service.edu1();
			 else
				 return new ArrayList<Education>();
		 }
	 
		 @DeleteMapping("/delete_education/{id}")
		 public Education deleteEducation(@PathVariable("id") int id) {
			 return service.deleteEducation(id);
		 }
		 
		
		    @PutMapping("/update_education/{id}")
		    public String updateEducation(@PathVariable("id") long id, @RequestBody Education education) {
		        return service.updateEducation(id, education);
		    }
		 
		    
		    //Its for publication
		    
		    @PostMapping("/insert_publication")
		    public String insertPublication(@RequestBody Publication publication) {
		        return service.insertPublication(publication);
		    }

		    @GetMapping("/pub1")
		    public List<Publication> getAllPublications() {
		        return service.getAllPublications();
		    }

		    @DeleteMapping("/delete_publication/{id}")
		    public Publication deletePublication(@PathVariable("id") long id) {
		        return service.deletePublication(id);
		    }

		    @PutMapping("/update_publication/{id}")
		    public String updatePublication(@PathVariable("id") long id, @RequestBody Publication publication) {
		        return service.updatePublication(id, publication);
		    }


}
