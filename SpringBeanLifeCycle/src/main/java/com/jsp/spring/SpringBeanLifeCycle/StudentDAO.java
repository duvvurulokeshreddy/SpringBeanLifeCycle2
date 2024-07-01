package com.jsp.spring.SpringBeanLifeCycle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class StudentDAO {

	private String url;
	private String userName;
	private String password;
	private String driver;
	Connection conn;
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		System.out.println("Setting URL");
		this.url = url;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		System.out.println("Setting UserName");
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		System.out.println("Setting Password");
		this.password = password;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		System.out.println("Setting driver");
		this.driver = driver;
	}
	@PostConstruct
	public void init() throws ClassNotFoundException, SQLException {
		System.out.println("Inside the custom init method");
		dbConnections();
	}

	public void dbConnections() throws ClassNotFoundException, SQLException {
		System.out.println("Creating The Connection Object");
		Class.forName(driver);
		conn = DriverManager.getConnection(url, userName, password);
	}

	public void selectAllRow() throws ClassNotFoundException, SQLException {
		System.out.println("Reteview The Data : ");
		//		dbConnections();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from esnew.hotelstudentinfo");
		while (rs.next()) {
			int studentId = rs.getInt(1);
			String studentName = rs.getString(2);
			int hotelFee = rs.getInt(3);
			String foodType = rs.getString(4);

			System.out.println(studentId + " " + studentName + " " + hotelFee + " " + foodType);
		}
	}


	public void deleteRow(int studentId) throws ClassNotFoundException, SQLException {
		System.out.println("Delete The Record from the table :");
		//		dbConnections();
		//		Execute The Query
		Statement stmt = conn.createStatement();
		int rs = stmt.executeUpdate("delete from esnew.hotelstudentinfo where studentId=" + studentId);
		System.out.println("Delete The Record From The table : " + studentId);

	}
	public void closeConnection() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@PreDestroy
	public void destroy() {
//		cleaning the data
		System.out.println("Data is represent");
		closeConnection();
	}
}
