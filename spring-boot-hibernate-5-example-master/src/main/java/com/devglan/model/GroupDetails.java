package com.devglan.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "GROUP_DETAILS")
public class GroupDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "GROUPNAME")
	private String groupName;
	
	@Column(name = "PATH")
	private String path;
	
	@Column(name = "ACTIVE")
	private String active;
	
	
	
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getGroupName() {
		return groupName;
	}



	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}



	public String getPath() {
		return path;
	}



	public void setPath(String path) {
		this.path = path;
	}



	public String getActive() {
		return active;
	}



	public void setActive(String active) {
		this.active = active;
	}



	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("Group Details \nID : %s\nGroup Name : %s\nPath : %s   ", id,groupName,path);
	}
}

