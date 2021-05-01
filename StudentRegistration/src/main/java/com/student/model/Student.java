package com.student.model;

import java.util.Arrays;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class Student {

    private Long id;
    @Size(min=3, max=40)
	private String name;
	private String city;
	@NotBlank @Email(message = "Please enter a valid e-mail address")
	private String emailId;
	private String course;
	@NotBlank
	private String gender;
	private String[] hobby;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String[] getHobby() {
		return hobby;
	}
	public void setHobby(String[] hobby) {
		this.hobby = hobby;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", city=" + city + ", emailId=" + emailId + ", course=" + course
				+ ", gender=" + gender + ", hobby=" + Arrays.toString(hobby) + "]";
	}
}
