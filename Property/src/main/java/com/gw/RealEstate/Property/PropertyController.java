package com.gw.RealEstate.Property;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.gw.RealEstate.Entity.PersonalDetails;
import com.gw.RealEstate.Entity.PropertyDetails;
import com.gw.RealEstate.Service.PropertyService;

@RestController
public class PropertyController {

	@Autowired
	private PropertyService service;
	
	@CrossOrigin(allowedHeaders= "*",allowCredentials="true")
	@RequestMapping("/getpersonaldetail")
	public List<PersonalDetails> getdetail(){
		return this.service.getdetail();
	}
	
	@CrossOrigin(allowedHeaders= "*",allowCredentials="true")
	@RequestMapping("/getpropertydetail")
	public List<PropertyDetails> getdetail1(){
		return this.service.getdetail1();
	}

	@CrossOrigin(allowedHeaders="*",allowCredentials="true")
	@PostMapping("/addpersonaldetail")
	public void addprop(@RequestBody PersonalDetails pd ){
		service.post(pd);
	}
	
	@CrossOrigin(allowedHeaders="*",allowCredentials="true")
	@PostMapping("/addpropertydetail/{id}")
	public void addprop1(@RequestBody PropertyDetails pcd,@PathVariable int id ){
		service.post1(pcd,id);
	}
	
    @CrossOrigin(allowedHeaders="*",allowCredentials="true")
    @PutMapping("/updateldetail/{id}")
    public void updateprop(@RequestBody PersonalDetails pd, @PathVariable int id){
    	service.update(id,pd);
    }
    
    @CrossOrigin(allowedHeaders="*",allowCredentials="true")
    @PutMapping("/updatepropertydetail/{id}")
    public String updateprop1(@RequestBody PropertyDetails pd){
  	service.update1(pd);
//    	System.out.println(pd.getType());
//    	System.out.println(pd.getAddress());
//    	System.out.println(pd.getArea());
//    	System.out.println(pd.getBathroom());
//    	System.out.println(pd.getEmail());
//    	System.out.println(pd.getInfo());
//    	System.out.println(pd.getName());
//    	System.out.println(pd.getPhone());
//    	System.out.println(pd.getpostalcode());
//    	System.out.println(pd.getPd());
    	return "updated";
    }
    
    @CrossOrigin(allowedHeaders="*",allowCredentials="true")
    @DeleteMapping("/deletedetail/{id}")
    public void deleteprop(@PathVariable int id){
    	service.delete(id);
    }
   
    @CrossOrigin(allowedHeaders="*",allowCredentials="true")
    @DeleteMapping("/deletepropertydetail/{id}")
    public void deleteprop1(@PathVariable int id){
    	service.delete1(id);
    }
    
}
