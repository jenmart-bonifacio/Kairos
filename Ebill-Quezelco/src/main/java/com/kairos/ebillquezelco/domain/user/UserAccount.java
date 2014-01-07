package com.kairos.ebillquezelco.domain.user;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table(name="tblUserAccount")
public class UserAccount implements Serializable {
	
	private static final long serialVersionUID = 826727317693096390L;

	@Id
	@GeneratedValue
	private Long id;
	
	@NotNull
	@NotEmpty
	@Size(max=70)
	private String firstName;
	
	@Size(max=70)
	private String middleName;
	
	@NotNull
	@NotEmpty
	@Size(max=70)
	private String lastName;

	@Transient
	private String fullName;
	
	@NotNull
	@NotEmpty
	@Size(max=20)
	@Column(unique=true)
	private String username;
	
	@NotNull
	@NotEmpty
	@Size(min=5)
	private String password;
	
	private Date dateCreated;
	
	private Boolean enabled;
	
	@NotNull
	@NotEmpty
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="tblUserRoles",
			joinColumns=@JoinColumn(name="user"),
			inverseJoinColumns=@JoinColumn(name="role"))
	private List<Roles> roles;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	public Boolean getEnabled() {
		return enabled;
	}
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFullName() {
		return fullName = !(middleName==null || "".equals(middleName)) //StringUtils.isEmpty(middleName)
						? firstName + " " + middleName.substring(0, 1) + ". " + lastName 
						: firstName + " " + lastName;
	}
	public List<Roles> getRoles() {
		return roles;
	}
	public void setRoles(List<Roles> roles) {
		this.roles = roles;
	}
	@Override
	public String toString() {
		return "UserAccount: " +
				String.valueOf(this.id) + " " + 
				this.firstName + " " + 
				this.lastName + " " + 
				this.middleName + " " + 
				this.username + " " + 
				this.password + " " + 
				String.valueOf(this.dateCreated) + " " + 
				String.valueOf(this.enabled);
	}
	
}