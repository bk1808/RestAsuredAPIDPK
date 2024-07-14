package com.ninzahrm.api.genericutility;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;


public class DatabaseUtility {

	FileUtility fLib = new FileUtility();
	Connection conn;

	/**
	 * 
	 * @param url
	 * @param un
	 * @param pwd
	 * @throws SQLException
	 * @throws IOException
	 */
	public void getDBConnection(String url, String un, String pwd) throws SQLException, IOException {

	
		try {
			Driver driverRef = new Driver();
			DriverManager.registerDriver(driverRef);
			conn = DriverManager.getConnection(fLib.getDataFromPropertiesFile("dburl"),
					fLib.getDataFromPropertiesFile("dbusername"), fLib.getDataFromPropertiesFile("dbpassword"));
		} catch (Exception e) {

			System.out.println("===Connection Done===");
		}
	}

	public void getDBConnection() throws SQLException {

		try {
			Driver driverRef = new Driver();
			DriverManager.registerDriver(driverRef);
			conn = DriverManager.getConnection("mysql:jdbc://localhost:3306/db_projects", "root", "root");
		} catch (Exception e) {
			System.out.println("===Connection Done===");
		}
	}

	public void closeConnection() throws SQLException {
		conn.close();
	}

	public boolean executeQueryVerifyAndGetData(String query, int columnIndex, String expectedData)
			throws SQLException {

		boolean flag = false;
		ResultSet result=null;
		result = conn.createStatement().executeQuery(query);

		while (result.next()) {

			if (result.getString(columnIndex).equals(expectedData)) {

				flag = true;
				break;
			}

		}
		if (flag) {
			System.out.println(expectedData + "===>data verified in DB table");
			return true;
		} else {
			System.out.println(expectedData + "===>data not verified in DB table");
			return false;
		}

	}

	public ResultSet executeSelectQuery(String query) throws SQLException {

		ResultSet result = null;

		try {
			Statement stat = conn.createStatement();
			result = stat.executeQuery(query);

		} catch (Exception e) {
			System.out.println("Exception handled");
		}

		return result;
	}

	public int executeNonSelectQuery(String query) throws SQLException {

		int result = 0;

		try {
			Statement stat = conn.createStatement();
			result = stat.executeUpdate(query);
		} catch (Exception e) {
			System.out.println("===Updated===");
		}

		return result;

	}

}
