package pro;

public class Students {

	private String FirstName;
	private String LastName;
	private long MobileNo;
	private String EmailId;
	private String Address;
	private Long AadharNo;
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public long getMobileNo() {
		return MobileNo;
	}
	public void setMobileNo(long mobileNo) {
		MobileNo = mobileNo;
	}
	public String getEmailId() {
		return EmailId;
	}
	public void setEmailId(String emailId) {
		EmailId = emailId;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public Long getAadharNo() {
		return AadharNo;
	}
	public void setAadharNo(Long aadharNo) {
		AadharNo = aadharNo;
	}
	public Students(String firstName, String lastName, long mobileNo, String emailId, String address, Long aadharNo) {
		super();
		FirstName = firstName;
		LastName = lastName;
		MobileNo = mobileNo;
		EmailId = emailId;
		Address = address;
		AadharNo = aadharNo;
	}
	public Students() {
		
	}
	@Override
	public String toString() {
		return "Students [FirstName=" + FirstName + ", LastName=" + LastName + ", MobileNo=" + MobileNo + ", EmailId="
				+ EmailId + ", Address=" + Address + ", AadharNo=" + AadharNo + "]";
	}
	
}
