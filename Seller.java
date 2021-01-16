import java.util.Date;

public class Seller extends Person {
	private int salary;
	private int phoneNumber;
	private Date appointedOn;
	
	public Seller(String name, int age, String gender, int salary, int phoneNumber) {
		super(name, age, gender);
		this.salary = salary;
		this.phoneNumber = phoneNumber;
		appointedOn = new Date();
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Date getAppointedOn() {
		return appointedOn;
	}

	public void setAppointedOn(Date appointedOn) {
		this.appointedOn = appointedOn;
	}

	public String toString() {
		return "Seller [salary=" + salary + ", phoneNumber=" + phoneNumber + ", name="
				+ getName() + ", age=" + getAge() + ", gender=" + getGender() + "]";
	}
}
