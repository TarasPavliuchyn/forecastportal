package com.forecastportal.domain.user;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * Persistent class for entity stored in table "user"
 *
 * @author Taras
 *
 */

@Entity
@Table(name = "user", catalog = "portal")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private Long id;

	@Column(name = "fname", nullable = false, length = 20)
	private String fname;

	@Column(name = "lname", nullable = false, length = 20)
	private String lname;

	@Column(name = "email", nullable = false, length = 45)
	private String email;

	@Column(name = "password", nullable = false, length = 100)
	private String password;

	@Column(name = "age", nullable = true)
	private Integer age;

	@Embedded
	private Address address;

	@Enumerated(EnumType.STRING)
	Gender gender;

	@Column(name = "role", nullable = true)
	@Enumerated(EnumType.STRING)
	Role role;

	@Column(name = "phone_number", nullable = false, length = 45)
	private String phoneNumber;

	@Column(name = "creation_time")
	@Temporal(TemporalType.TIMESTAMP)
	private Date creationTime;
	@Column(name = "activated")
	private Boolean activated;

	public User() {
		super();
	}

	public User(Long id, String fname, String lname, String email,
			String password, Integer age, Address address, Gender gender,
			Role role, String phoneNumber) {
		super();
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.password = password;
		this.age = age;
		this.address = address;
		this.gender = gender;
		this.role = role;
		this.phoneNumber = phoneNumber;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
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

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Date getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	public Boolean getActivated() {
		return activated;
	}

	public void setActivated(Boolean activated) {
		this.activated = activated;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", fname=" + fname + ", lname=" + lname
				+ ", email=" + email + ", password=" + password + ", age="
				+ age + ", address=" + address + ", gender=" + gender
				+ ", role=" + role + ", phoneNumber=" + phoneNumber
				+ ", creationTime=" + creationTime + ", activated=" + activated
				+ "]";
	}

}
