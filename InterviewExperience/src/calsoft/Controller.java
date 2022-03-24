package calsoft;

import java.util.List;

//@RestController
//@GetMapping(/api/v1/)
public class Controller {

	// @Autowire
	private Service service;

	// @GetMapping(/getAllEmployes)
	public List getAllEmp() {
		return service.getAllEmployees();
	}
}
