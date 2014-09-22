package com.sapient.equitytradingapp.pm.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;

/**
 * POJO for "users" table
 */
@Component
@Entity
@Table(name = "users")
public class User {

	@Id
	private String username;
	@Column(name = "password")
	private String password;
	@Column(name = "roles")
	private String roles;
	@Column(name = "question")
	private String question;
	@Column(name = "answer")
	private String answer;

	@RequiredStringValidator(key = "username.required", type = ValidatorType.SIMPLE, fieldName = "user.username")
	public String getUsername() {
		System.out.println(this.username);
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@RequiredStringValidator(key = "password.required", type = ValidatorType.SIMPLE, fieldName = "user.password")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

}
