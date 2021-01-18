package com.nisum.nisum.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import com.sun.istack.NotNull;

@Entity
@Table(name="User")
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id")
    private long id;
    
    @NotNull
    @Column(name="name")
    private String name;
    
    @Email
    @javax.validation.constraints.NotBlank
    @NotNull
    @Column(name="email")
    private String email;
    @NotNull
    @Column(name="password")
    private String password;
    

    @Embedded
    private List<Phones> phones;

    @Column(name="created_at")
    @CreationTimestamp
    private Date createdAt;

    @Column(name="updated_at")
    @UpdateTimestamp
    private Date updatedAt;

    public User() {}

    public User(Long id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }
    
    public User(Long id, String name, String email, String password) {
        this.id = id;
        this.name=name;
        this.email = email;
        this.password = password;
    }
    
    public User(String name, String email, String password) {
        this.name=name;
        this.email = email;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
    
    

    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Phones> getPhones() {
		return phones;
	}

	public void setPhones(List<Phones> phones) {
		this.phones = phones;
	}

	@Override
    public String toString() {
        return "User [id=" + id + ", email=" + email + ", password=" + password + ", createdAt=" + createdAt
                + ", updatedAt=" + updatedAt + "]";
    }


}