package com.Samathdada.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="roles")
public class Role {
	
	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	private Long roleId;
	private String rolename;
	
	@OneToMany(cascade= CascadeType.ALL,fetch=FetchType.LAZY,mappedBy="role")
	private Set<UserRole> userRoles=new HashSet<>();
	
	public Set<UserRole> getUserRoles() {
		return userRoles;
	}


	public void setUserRoles(Set<UserRole> userRoles) {
		this.userRoles = userRoles;
	}


	public Role() {
		//super();
		// TODO Auto-generated constructor stub
	}


	public Long getRoleId() {
		return roleId;
	}


	public void setRoleId(Long i) {
		this.roleId = i;
	}


	public String getRolename() {
		return rolename;
	}


	public void setRolename(String rolename) {
		this.rolename = rolename;
	}


	public Role(Long roleId, String rolename) {
		super();
		this.roleId = roleId;
		this.rolename = rolename;
	}
	

}
