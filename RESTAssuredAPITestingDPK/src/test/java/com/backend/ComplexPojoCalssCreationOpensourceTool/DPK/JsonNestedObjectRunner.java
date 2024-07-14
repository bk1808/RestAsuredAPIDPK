package com.backend.ComplexPojoCalssCreationOpensourceTool.DPK;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonNestedObjectRunner {

	public static void main(String[] args) throws Throwable, DatabindException, IOException {

		ArrayList<String> teamMembers = new ArrayList<String>();
		teamMembers.add("John");
		teamMembers.add("David");
		teamMembers.add("Steve");
		ProjectManager pmobj = new ProjectManager("Sagar", 001);
		
		JsonNestedObjectPojoTest jsonObjPojo = new JsonNestedObjectPojoTest("SCM_001", "Created", 10, teamMembers, pmobj);
		
		System.out.println(jsonObjPojo.getProjectName());
		System.out.println(jsonObjPojo.getProjectStatus());
		System.out.println(jsonObjPojo.getTeamSize());
		System.out.println(jsonObjPojo.getPmobj().getName());
		System.out.println(jsonObjPojo.getPmobj().getId());
		
		/*Converting the above data back to Jason object using Jackson objectMapper class this is the example of serialization*/
		
		ObjectMapper objMap = new ObjectMapper();//this class is coming from 'Jackson databind' dependency
		
		objMap.writeValue(new File("./src/test/resources/pojodemo.ser"), jsonObjPojo);
		System.out.println("===END===");
		
		
		
		
		
		
		
		
	}

}
