package com.backend.ComplexPojoCalssCreationOpensourceTool.DPK;

public class ProjectManager {

	private String name;
	private int id;
	
	
	public ProjectManager() {
		super();
	}

	public ProjectManager(String name, int id) {
		super();
		this.name = name;
		this.id = id;
	}

	
	public String getName() {
		return name;
	}
	
	public int getId() {
		return id;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	

	
	
}
