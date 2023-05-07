package marshalAndUnmarshal.Controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.xml.bind.JAXBException;
import marshalAndUnmarshal.Entity.Employee;
import marshalAndUnmarshal.Service.EmployeeService;

@RestController
public class EmployeeController {
    
	@Autowired
    private EmployeeService employeeService;
     
    @PostMapping("/marshal")
    public void marshal(@RequestBody Employee employee, HttpServletResponse response) throws IOException, JAXBException {
        response.setContentType("xml");
        employeeService.marshal(employee, response.getOutputStream());
    }
    
    @GetMapping("/unmarshal")
    public Employee getEmployee() throws JAXBException {
        return employeeService.unmarshalEmployee();
    }   
    
    @DeleteMapping("/file")
    public ResponseEntity<Object> deleteFile() {
    	return employeeService.deleteFile();
    }
}