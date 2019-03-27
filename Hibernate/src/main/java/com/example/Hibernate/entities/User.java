package com.example.Hibernate.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@Table(name = "USERS")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "USER_NAME")
	@NotNull(message = "is required")
	private String userName;
	
	@Column(name = "PASSWORD")
	@NotNull(message = "is required")
	private String password;
	
	@Column(name = "ROLE")
	private String role;

	public User() {
		// TODO Auto-generated constructor stub
	}

    @Override
    public String toString()
    {
        return "User [id=" + id + ", userName=" + userName + ", password=" + password + ", role=" + role + "]";
    }
	
	/*public User(SignUp signUp) {
		this.userName = signUp.getUserName();
		this.password = signUp.getPassword();
		this.role = signUp.getRole();
	}*/
	
	
	
}


