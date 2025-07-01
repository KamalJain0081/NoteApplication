package com.utilityMethods;

import java.sql.DriverManager;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import jakarta.annotation.PostConstruct;

@Configuration
public class ConnectionClass
{
	@Value("${spring.datasource.url}")
	private String URL;
	
	@Value("${spring.datasource.username}")
	private String USERNAME;
	
	@Value("${spring.datasource.password}")
	private String PASSWORD;
	
	@PostConstruct
	public void getConnection()
	{
		System.out.println("DB_URL : " + URL + " || USERNAME : " + USERNAME + " || PASSWORD : " + PASSWORD);
		
		try 
		{
			Class.forName("org.postgresql.Driver");
			DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("Connected to PostgreSQL database!");
		} 
		catch (Exception e) 
		{
			System.out.println("Connection Error : ");
			e.printStackTrace();
		}
		
	}
	
}
