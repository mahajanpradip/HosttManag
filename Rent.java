
package pro;

public class Rent {

	private int StudentId;
	private String Name;
	private String LastName;
	private double Deposit;
	private double rent;
	public int getStudentId() {
		return StudentId;
	}
	public void setStudentId(int studentId) {
		StudentId = studentId;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public double getDeposit() {
		return Deposit;
	}
	public void setDeposit(double deposit) {
		Deposit = deposit;
	}
	public double getRent() {
		return rent;
	}
	public void setRent(double rent) {
		this.rent = rent;
	}
	public Rent(int studentId, String name, String lastName, double deposit, double rent) {
		super();
		StudentId = studentId;
		Name = name;
		LastName = lastName;
		Deposit = deposit;
		this.rent = rent;
	}
	public Rent() {
	
	}
	@Override
	public String toString() {
		return "rent [StudentId=" + StudentId + ", Name=" + Name + ", LastName=" + LastName + ", Deposit=" + Deposit
				+ ", rent=" + rent + "]";
	}
	
	
}
