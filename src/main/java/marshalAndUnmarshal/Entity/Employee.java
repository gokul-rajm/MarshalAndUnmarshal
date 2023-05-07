package marshalAndUnmarshal.Entity;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Employee {
    
    private String name;
    private int age;
    private String email;
    private int mobileNo;
    
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(int mobileNo) {
		this.mobileNo = mobileNo;
	}
	
	public Employee() {
		super();
	}
	
	public Employee(String name, int age, String email, int mobileNo) {
		super();
		this.name = name;
		this.age = age;
		this.email = email;
		this.mobileNo = mobileNo;
	}
	
	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + ", email=" + email + ", mobileNo=" + mobileNo + "]";
	}
}

