package org.insang.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
public class Student {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;

	@Column(nullable=false)
	@NotEmpty
	private String name;
	
//	@Column(nullable=true)
//	@Email(message="Wrong Email")
//	private String email;
	
	@Column(nullable=false)
	@NotEmpty
	private String major;
	
	@Min(value=0)
	@Max(value=100)
	private int midScore;
	
	@Min(value=0)
	@Max(value=100)
	private int finalScore;
	
	@Min(value=0)
	@Max(value=100)
	private int hwScore;
	
	@Min(value=0)
	@Max(value=100)
	private double totalScore;
	
	private Grade grade;

	public void setId(long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}


	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}


	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public int getMidScore() {
		return midScore;
	}

	public void setMidScore(int midScore) {
		this.midScore = midScore;
	}

	public int getFinalScore() {
		return finalScore;
	}

	public void setFinalScore(int finalScore) {
		this.finalScore = finalScore;
	}

	public int getHwScore() {
		return hwScore;
	}

	public void setHwScore(int hwScore) {
		this.hwScore = hwScore;
	}

	public double getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(double totalScore) {
		this.totalScore = totalScore;
	}

	public Grade getGrade() {
		return grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}
}
