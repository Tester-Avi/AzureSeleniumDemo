package TestNG_5;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfigFile {

	Properties properties;
	String path = "C:\\Users\\Avagarwal\\eclipse-workspace\\SeleniumTestN\\src\\test\\java\\TestNG_4\\config.properties";

	public ReadConfigFile()
	{
		properties = new Properties();

		try {
			FileInputStream fis = new FileInputStream(path);
			try {
				properties.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	public String getURL()
	{
		String URL = properties.getProperty("url");
		
		if (URL!=null)
		{
			return URL;
		}
		else
			throw new RuntimeException("url not specified in config file");
	}
	
	
	public String getUsername()
	{
		String uname = properties.getProperty("username");
		
		if (uname!=null)
		{
			return uname;
		}
		else
			throw new RuntimeException("Username not specified in config file");
	}
	
	public String getPassword()
	{
		String pwd = properties.getProperty("password");
		
		if (pwd!=null)
		{
			return pwd;
		}
		else
			throw new RuntimeException("Password not specified in config file");
	}
}
