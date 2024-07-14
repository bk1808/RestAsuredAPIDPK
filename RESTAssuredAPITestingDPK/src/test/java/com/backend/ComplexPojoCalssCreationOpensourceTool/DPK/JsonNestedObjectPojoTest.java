package com.backend.ComplexPojoCalssCreationOpensourceTool.DPK;

import java.util.List;

import org.json.simple.JSONObject;

public class JsonNestedObjectPojoTest {

	/* Sample JSON object with Array and nested object */
	/*
	 * { "projectName" : "Orange",
	 * "projectStatus" : "Created",
	 * "teamMember" : ["John", "Steve", "David"],
	 * "projectManager" : { "name" : "Sagar",
	 * "id" : "TP_001" }
	 * 
	 * }
	 */
	
	private String  projectName;
	private String projectStatus;
	private int teamSize;
	private List<String> teamMember;
	private ProjectManager pmobj;
	
	private JsonNestedObjectPojoTest() {
		super();
	}

	public JsonNestedObjectPojoTest(String projectName, String projectStatus, int teamSize, List<String> teamMember,
			ProjectManager pmobj) {
		super();
		this.projectName = projectName;
		this.projectStatus = projectStatus;
		this.teamMember = teamMember;
		this.pmobj = pmobj;
	}

	public String getProjectName() {
		return projectName;
	}

	public String getProjectStatus() {
		return projectStatus;
	}

	public List<String> getTeamMember() {
		return teamMember;
	}

	public ProjectManager getPmobj() {
		return pmobj;
	}

	public int getTeamSize() {
		return teamSize;
	}

	
	
	public void setTeamSize(int teamSize) {
		this.teamSize = teamSize;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public void setProjectStatus(String projectStatus) {
		this.projectStatus = projectStatus;
	}

	public void setTeamMember(List<String> teamMember) {
		this.teamMember = teamMember;
	}

	public void setPmobj(ProjectManager pmobj) {
		this.pmobj = pmobj;
	}
	
	
}
