package org.parentsstepahead.application.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="parent")
public class Parent{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idParent")
	private int idParent;
	
	@Column(name="firstName")
	private String firstName;
	
	@Column(name="lastName")
	private String lastName;
	
	@Column(name="countryOfOrigin")
	private String countryOfOrigin;
	
	/*@Column(name="gender")
	private String gender;
	
	@Column(name="civilStatus")
	private String civilStatus;
	
	@Column(name="countryOfOrigin")
	private String countryOfOrigin;
	
	@Column(name="educationLevel")
	private String educationLevel;
	
	@Column(name="salaryRange")
	private int salaryRange;
	
	@Column(name="numberOfChildren")
	private int numberOfChildren;
	
	@Column(name="phoneNumber")
	private int phoneNumber;
	
	@Column(name="email")
	private String email;
	
	@OneToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name="idAddress")
	private Address address;
	
	@OneToMany(fetch = FetchType.LAZY,
			cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	private List<Child> childrenList;
	
	//constructors

	public Parent() {}

	public Parent(String firstName, String lastName, String gender, String civilStatus, String countryOfOrigin,
			String educationLevel, int salaryRange, int numberOfChildren, int phoneNumber, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.civilStatus = civilStatus;
		this.countryOfOrigin = countryOfOrigin;
		this.educationLevel = educationLevel;
		this.salaryRange = salaryRange;
		this.numberOfChildren = numberOfChildren;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}*/
	
	
	//Temporal constructor
	public Parent() {}
	public Parent(String firstName, String lastName, String countryOfOrigin) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.countryOfOrigin = countryOfOrigin;
	}
	
	
	//setters and getters
	public int getIdParent() {
		return idParent;
	}

	public void setIdParent(int idParent) {
		this.idParent = idParent;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getCountryOfOrigin() {
		return countryOfOrigin;
	}

	public void setCountryOfOrigin(String countryOfOrigin) {
		this.countryOfOrigin = countryOfOrigin;
	}

/*
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCivilStatus() {
		return civilStatus;
	}

	public void setCivilStatus(String civilStatus) {
		this.civilStatus = civilStatus;
	}

	public String getCountryOfOrigin() {
		return countryOfOrigin;
	}

	public void setCountryOfOrigin(String countryOfOrigin) {
		this.countryOfOrigin = countryOfOrigin;
	}

	public String getEducationLevel() {
		return educationLevel;
	}

	public void setEducationLevel(String educationLevel) {
		this.educationLevel = educationLevel;
	}

	public int getSalaryRange() {
		return salaryRange;
	}

	public void setSalaryRange(int salaryRange) {
		this.salaryRange = salaryRange;
	}

	public int getNumberOfChildren() {
		return numberOfChildren;
	}

	public void setNumberOfChildren(int numberOfChildren) {
		this.numberOfChildren = numberOfChildren;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Child> getChildrenList() {
		return childrenList;
	}

	public void setChildrenList(List<Child> childrenList) {
		this.childrenList = childrenList;
	}
	
	//String to String
	@Override
	public String toString() {
		return "Parent [idParent=" + idParent + ", firstName=" + firstName + ", lastName=" + lastName + ", gender="
				+ gender + ", civilStatus=" + civilStatus + ", countryOfOrigin=" + countryOfOrigin + ", educationLevel="
				+ educationLevel + ", salaryRange=" + salaryRange + ", numberOfChildren=" + numberOfChildren
				+ ", phoneNumber=" + phoneNumber + ", email=" + email + "]";
	}
	
	//add convenience method
	public void add(Child theChild) {
		if(childrenList == null) {
			childrenList = new ArrayList<>();
		}
		
		childrenList.add(theChild);		
	}*/
	

}
