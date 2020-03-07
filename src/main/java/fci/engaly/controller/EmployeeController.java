package fci.engaly.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fci.engaly.dao.EmployeeRepository;
import fci.engaly.model.Employee;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

//@CrossOrigin(origins = "http://localhost:4200")
@Controller
public class EmployeeController {

	@Autowired
	private EmployeeRepository repository;

	@GetMapping("/employees")
	public String getEmployees(@PageableDefault(size = 10, sort = "id") Pageable pageable, Model model) {
		Page<Employee> page = repository.findAll(pageable);
		List<Sort.Order> sortOrders = page.getSort().stream().collect(Collectors.toList());
		if (sortOrders.size() > 0) {
			Sort.Order order = sortOrders.get(0);
			model.addAttribute("sortProperty", order.getProperty());
			model.addAttribute("sortDesc", order.getDirection() == Sort.Direction.DESC);
		}
		model.addAttribute("page", page);
		return "employeePage";
	}

	@GetMapping("test")
	@ResponseBody public String getNames() {
		return "my name is aly";
	}

}