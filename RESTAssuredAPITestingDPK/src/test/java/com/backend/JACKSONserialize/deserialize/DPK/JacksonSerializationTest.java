package com.backend.JACKSONserialize.deserialize.DPK;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

class Project{ //POJO class [Plain Old Java Object]
	
	private String projectName;
	private String createdBy;
	private int teamSize;
	private String status;
	
	
	public Project() {
		super();
	}


	public Project(String projectName, String createdBy, int teamSize, String status) {
		super();
		this.projectName = projectName;
		this.createdBy = createdBy;
		this.teamSize = teamSize;
		this.status = status;
	}


	public String getProjectName() {
		return projectName;
	}


	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}


	public String getCreatedBy() {
		return createdBy;
	}


	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}


	public int getTeamSize() {
		return teamSize;
	}


	public void setTeamSize(int teamSize) {
		this.teamSize = teamSize;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}

}

public class JacksonSerializationTest {

	public static void main(String[] args) throws Throwable, DatabindException, IOException {
		
		Project pobject = new Project("SCM_002", "Praveen", 15, "Created");
		
		ObjectMapper map = new ObjectMapper();
		
		map.writeValue(new File ("./src/test/resources/project.json"), pobject);
		System.out.println("==END==");
		
	}
	
	
}
