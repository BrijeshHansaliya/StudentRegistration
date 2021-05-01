package com.student.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class StudentEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "student_id")
	private Long id;
	private String name;
	private String city;
	private String emailId;
	private String course;
	private String gender;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "student", cascade = CascadeType.ALL)
	private Set<HobbyEntity> hobby = new HashSet<HobbyEntity>();

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

	public Set<HobbyEntity> getHobby() {
		return hobby;
	}

	public void setHobby(Set<HobbyEntity> hobby) {
		this.hobby = hobby;
	}

	@Override
	public String toString() {
		return "StudentEntity [id=" + id + ", name=" + name + ", city=" + city + ", emailId=" + emailId + ", course="
				+ course + ", gender=" + gender + ", hobby=" + hobby + "]";
	}

}
