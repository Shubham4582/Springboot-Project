package com.Springboot_Demo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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

	@GetMapping("/all")
	public List<Employee> getAll(){
		return jpa1.findAll();
	}
	@PostMapping("/create")
	public String createEmployee(@RequestBody Employee e) {
		System.out.println(e.getId() + " " + e.getName() + " " + e.getSalary());
		jpa1.save(e);
//		System.out.println(e.getProject());
//		System.out.println(e.getSkills());
		return e.getId() + " " + e.getName() + " " + e.getSalary();
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