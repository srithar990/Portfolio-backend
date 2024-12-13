package com.example.demo.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
@org.springframework.stereotype.Service


public class Service {
	@Autowired
	PatentsRepo repo1;
	public String insertPatents(Patents patents) {
		repo1.save(patents);
		return "inserted successfully";
	}
	
	public List<Patents> all(){
		return repo1.findAll();
	}
	
	@Autowired
	LoginRepo repo2;
	
	@Autowired
	UserRepo repo5;
	
	@Autowired
	JWTManager jwt;
	
	public String insertUser(User user) {
		repo5.save(user);
		return "Inserted";
	}
	
	public List<User> viewUser() {
		return repo5.findAll();	
	}
	
	public Map<String, String> userAuth(User user) {
		User user2=repo5.findByuname(user.getUname());
		Map<String, String> res=new HashMap<>();
		if(user2==null) {
		res.put("login","fail");
		}
		else if(user2.getUpassword().equals(user.getUpassword()))
		{
			res.put("login", "success");
			res.put("role", user2.getRole());
			res.put("token", jwt.generateToken(user2.getRole()));
		}
		else {
			res.put("login", "fail");
		}
		return res;
	}
	
	public Map<String, String> viewUser(Login login) {
		Login login2=repo2.findByUsername(login.getUsername());
		Map<String, String> res=new HashMap<>();
		if(login2==null) {
		res.put("login","fail");
		}
		else if(login2.getPassword().equals(login.getPassword()))
		{
			res.put("login", "success");
		}
		else {
			res.put("login", "fail");
		}
		return res;
	}
	
	
	
	//Its for Education
	@Autowired
	EducationRepo edurepo1;
	public String insertEducation(Education education) {
		edurepo1.save(education);
		return "inserted successfully";
	}
	
	public List<Education> edu1(){
		return edurepo1.findAll();
	}
	
	public Education deleteEducation(int id) {
		edurepo1.deleteById((long)id);
		return null;
	}
	
	public String updateEducation(long id, Education education) {
        Optional<Education> existingEducation = edurepo1.findById(id);
        if (existingEducation.isPresent()) {
            Education updatedEducation = existingEducation.get();
            updatedEducation.setDegree(education.getDegree());
            updatedEducation.setSpec(education.getSpec());
            updatedEducation.setUniv(education.getUniv());
            updatedEducation.setYear(education.getYear());
            edurepo1.save(updatedEducation);
            return "Education updated successfully";
        } else {
            return "Education with id " + id + " not found";
        }
    }
	
	
	//Its for Publication
	@Autowired
	PublicationRepo publicationRepo;

	public String insertPublication(Publication publication) {
	    publicationRepo.save(publication);
	    return "Inserted successfully";
	}

	public List<Publication> getAllPublications() {
	    return publicationRepo.findAll();
	}

	public Publication deletePublication(long id) {
	    publicationRepo.deleteById(id);
	    return null; // You might want to return a confirmation or the deleted object.
	}

	public String updatePublication(long id, Publication publication) {
	    Optional<Publication> existingPublication = publicationRepo.findById(id);
	    if (existingPublication.isPresent()) {
	        Publication updatedPublication = existingPublication.get();
	        updatedPublication.setTitle(publication.getTitle());
	        updatedPublication.setAuthors(publication.getAuthors());
	        updatedPublication.setJournal(publication.getJournal());
	        updatedPublication.setVolume(publication.getVolume());
	        updatedPublication.setYear(publication.getYear());
	        updatedPublication.setIndexing(publication.getIndexing());
	        updatedPublication.setQuartile(publication.getQuartile());
	        updatedPublication.setLink(publication.getLink());
	        publicationRepo.save(updatedPublication);
	        return "Publication updated successfully";
	    } else {
	        return "Publication with id " + id + " not found";
	    }
	}

	
	
	
	

}



