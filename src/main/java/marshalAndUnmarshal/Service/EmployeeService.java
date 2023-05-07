package marshalAndUnmarshal.Service;

import java.io.File;
import java.io.OutputStream;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import marshalAndUnmarshal.Entity.Employee;

@Service
public class EmployeeService {
    
    public void marshal(Employee employee, OutputStream outputStream) throws JAXBException {
        JAXBContext jaxbcontext = JAXBContext.newInstance(Employee.class);
        Marshaller marshaller = jaxbcontext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(employee, outputStream);
        marshaller.marshal(employee, new File("employee.xml"));
    }
    
    public Employee unmarshalEmployee() throws JAXBException {
    	JAXBContext jaxbcontext = JAXBContext.newInstance(Employee.class);
    	Unmarshaller unmarshaller = jaxbcontext.createUnmarshaller();
    	Employee employee = (Employee) unmarshaller.unmarshal(new File("employee.xml"));
    	return employee;
    }

	public ResponseEntity<Object> deleteFile() {
		File file = new File("employee.xml");
        if (file.exists()) {
            file.delete();
            return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
            //return ResponseEntity.noContent().build();
        } else {
        	return new ResponseEntity<>("File Not Found", HttpStatus.NOT_FOUND);
            //return ResponseEntity.notFound().build();
        }
	}
}

