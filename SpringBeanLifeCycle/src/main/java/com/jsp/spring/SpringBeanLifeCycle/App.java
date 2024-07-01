package com.jsp.spring.SpringBeanLifeCycle;

import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws ClassNotFoundException, SQLException {
    	ApplicationContext context=new ClassPathXmlApplicationContext("spring.xml");
    	StudentDAO dao = context.getBean("studentDAO",StudentDAO.class);
    	System.out.println(dao);
    	System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::");
    	dao.selectAllRow();
    	System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::");
//    	dao.deleteRow(3);
//    	System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::");
//    	dao.selectAllRow();
    	
    	Hello hello=context.getBean("hello",Hello.class);
    	
    	((ClassPathXmlApplicationContext)context).close();
    }
}
