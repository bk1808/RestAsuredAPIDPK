package com.backend.JACKSONserialize.deserialize.DPK;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonDeserializationTest {

	public static void main(String[] args) throws Throwable, DatabindException, IOException {

		
		ObjectMapper map = new ObjectMapper();
		
		Project pobj = map.readValue(new File("./src/test/resources/project.json"), Project.class);
		
		System.out.println(pobj.getProjectName());
		System.out.println(pobj.getStatus());
		System.out.println(pobj.getTeamSize());
		System.out.println(pobj.getCreatedBy());
		
	}

}
