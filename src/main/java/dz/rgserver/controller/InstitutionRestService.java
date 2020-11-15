package dz.rgserver.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import dz.rgserver.dao.InstitutionRepository;
import dz.rgserver.model.Activite;
import dz.rgserver.model.Institution;
import dz.rgserver.model.Rg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class InstitutionRestService {
	
	@Autowired
	private InstitutionRepository institutionRepository;
	
	
	@RequestMapping(value="/institutions", method = RequestMethod.GET)
	public List<Institution> getAllInstituions(){
		return institutionRepository.findAll();
	}
	
	
	
	@RequestMapping(value="/institutions/{id}", method = RequestMethod.GET)
	public Institution getOneInstituion(@PathVariable long id ){
		return institutionRepository.findById(id).get();
	}
	
	

	@RequestMapping(value="/institutions", method = RequestMethod.POST)
	public Institution saveInstituion(@RequestBody Institution institution ){
		return institutionRepository.save(institution);
	}
	
	
	@RequestMapping(value="/institutions/{id}", method = RequestMethod.DELETE)
	public  boolean deleteInstituion(@PathVariable long id ){
		institutionRepository.deleteById(id);
		return true;
	}
	
	
	
	@RequestMapping(value="/institutions/{id}", method = RequestMethod.PUT)
	public Institution updateInstituion(@PathVariable long id ,@RequestBody Institution institution ){
		institution.setId(id);
		return institutionRepository.save(institution);
	}		
	
	
	 @RequestMapping(value = "/institutions/find/{id}", method = RequestMethod.GET)
	public Institution find(@PathVariable long id) {
		return institutionRepository.findByRgId(id);  
	}
	
	
	
}
