package kr.or.yi.gradle_mybatis_dev.dto;

import java.util.Date;

public class Student {
	private int studId;
	private String name;
	private String email;
	private PhoneNumber phone;
	private Date dob;
	private Address address;
	private Gender gender;
	
	
	
	public Student() {

	}

	public Student(int studId) {
		super();
		this.studId = studId;
	}

	public Student(int studId, String name, String email, PhoneNumber phone, Date dob) {
		super();
		this.studId = studId;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.dob = dob;
	}
	
	

	public Student(int studId, String name, String email, PhoneNumber phone, Date dob, Address address) {
		super();
		this.studId = studId;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.dob = dob;
		this.address = address;
	}
	
	

	public Student(int studId, String name, String email, PhoneNumber phone, Date dob, Address address, Gender gender) {
		super();
		this.studId = studId;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.dob = dob;
		this.address = address;
		this.gender = gender;
	}

	public int getStudId() {
		return studId;
	}

	public void setStudId(int studId) {
		this.studId = studId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public PhoneNumber getPhone() {
		return phone;
	}

	public void setPhone(PhoneNumber phone) {
		this.phone = phone;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	
	
	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Student [studId=" + studId + ", name=" + name + ", email=" + email + ", phone=" + phone + ", dob=" + dob
				+ ", address=" + address + ", gender=" + gender + "]";
	}

}
