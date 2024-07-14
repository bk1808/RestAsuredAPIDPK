package com.backend.ComplexPojoCalssCreationOpensourceTool.DPK;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class JsonObjectArrayPojoTest {

	/* Sample JSON object with Array and nested object */
	/*
	 * { "projectName" : "Orange",
	 * "projectStatus" : "Created",
	 * "teamMember" : ["John", "Steve", "David"],
	 * "projectManagers" :
	 * 
	 * [{ "name" : "Sager",
	 * "id" : "TP_001" },
	 * { "name" : "RP",
	 * "id" : "TP_002"}]
	 * }
	 */
	
	private String projectName;
	private String projectStatus;
	private List<String> teamMember;
	private List<ProjectManagers> arrayObj;
	
	
	public JsonObjectArrayPojoTest() {
		super();
	}


	public JsonObjectArrayPojoTest(String projectName, String projectStatus, List<String> teamMember,
			List<ProjectManagers> arrayObj) {
		super();
		this.projectName = projectName;
		this.projectStatus = projectStatus;
		this.teamMember = teamMember;
		this.arrayObj = arrayObj;
	}
	
	
	
	
	
}
