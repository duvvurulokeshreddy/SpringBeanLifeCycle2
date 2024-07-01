package com.jsp.spring.SpringBeanLifeCycle;

import java.sql.SQLException;

public class Hello {
	
	public void init() throws ClassNotFoundException, SQLException {
		System.out.println("Inside hello the custom init method");
	}
	
	public void destroy() {
//		cleaning the data
		System.out.println("hello is represent");
	}

}
