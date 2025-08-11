package com.Springboot_Demo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//@Controller 
@RestController // @RestController is used to send the data from Client to Controller
// search for only view page
public class Demo_Controller {

	@Autowired
	Employee_JPA jpa1;
	@Autowired
	Employee_DAO dao;
	@Autowired
	Mobile_JPA jpa2;

	@GetMapping("/a")
	// @ResponseBody
	// Transfer the data for the view with this @Controller gave the error
	public String getHi() {
		return "HI from GET";
	}

	@PostMapping("/a")
	public String postHi() {
		return "HI from POST";
	}

	@PostMapping("/b")
	public String requestHi(@RequestParam String name) {
		return name;
	}

//	@GetMapping("/all")
//	public List<Employee> getAll() {
//		return jpa1.findAll();
//	}

	@GetMapping("/all")
	public List<Employee> getAll() {
		return dao.getAllEmployees();
	}

//	@PostMapping("/create")
//	public String createEmployee(@RequestBody Employee e) {
//		System.out.println(e.getId() + " " + e.getName() + " " + e.getSalary());
//		jpa1.save(e);
////		System.out.println(e.getProject());
////		System.out.println(e.getSkills());
//		return e.getId() + " " + e.getName() + " " + e.getSalary();
//	}

	@PostMapping("/create")
	public Employee createEmployee(@RequestBody Employee e) {
		return dao.saveEmployee(e);
	}

//	@GetMapping("/get")
//	public Employee getEmployee(@RequestParam int id) {
//		Optional<Employee> option = jpa1.findById(id);
////		jpa1.delete(option.get()); // also used to delete the employee by object
//		return option.isPresent() ? option.get() : option.get();
//	}

	@GetMapping("/get")
	public Employee getEmployee(@RequestParam int id) {
		Optional<Employee> option = dao.getEmployeeById(id);
		return option.isPresent() ? option.get() : option.get();
	}

//	@DeleteMapping("/delete")
//	public String deleteEmployee(@RequestParam int id) {
//		Optional<Employee> option = jpa1.findById(id);
//		if (option.isPresent()) {
//			jpa1.delete(option.get());
//			return "Removed";
//		} else {
//			return "Not Exist";
//		}
//	}
	
	@DeleteMapping("/delete")
	public String deleteEmployee(@RequestParam int id) {
	    Optional<Employee> option = dao.getEmployeeById(id);
	    if (option.isPresent()) {
	        dao.deleteEmployee(id);
	        return "Removed";
	    } else {
	        return "Not Exist";
	    }
	}


//	@GetMapping("/name")
//	public List<Employee> getName(@RequestParam String name) {
//		return jpa1.getByName(name);
//	}

//	@GetMapping("/name/{name}")
//	public List<Employee> findName(@PathVariable String name) {
//		return jpa1.findByName(name);
//	}
	
	@GetMapping("/name/{name}")
	public List<Employee> findName(@PathVariable String name) {
	    return dao.getEmployeesByName(name);
	}


	@PostMapping("/mobile")
	public String createMobile(@RequestBody Mobile m) {
		jpa2.save(m);
//		System.out.println(m.getApp());

//		List<App> app = m.getApp();
//		for (App i : app) {
//			System.out.println(i.getUser());
//		}
		return m.getBrand();
	}

	@GetMapping("/getemp")
	public Employee getEmployee() {
		Employee e = new Employee();
		e.setId(1);
		e.setName("Miller");
		e.setSalary(20000);
//		e.setProject(List.of("HMS", "CRM", "Insurance"));
		Map<String, String> m = new HashMap();
		m.put("1", "Java");
		m.put("2", "SQL");
		m.put("3", "Github");
//		e.setSkills(m);
		return e;
	}
}