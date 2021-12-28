package Resources;

import Utils.PathHelper;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;



public class PropertyReader implements ConfigurationReader{
	
	
	Properties properties=null;
	
	public PropertyReader(){
		properties=new Properties();
		try {
			properties.load(PathHelper.getInputStreamResourcePath("/src/main/java/data/config.properties"));
		} catch (FileNotFoundException e) {
			System.out.println("Error occurred :  " + e.getMessage());
		} catch (IOException e) {
			System.out.println("Error occurred :  " + e.getMessage());
		}
		catch (NullPointerException e) {
			System.out.println("Error occurred :  " + e.getMessage());
		}

	}

	
	
	@Override
	public String getplatformName() {
		return properties.getProperty("");
	}
	
	

	

	@Override
	public String getApp() {
		return null;
		
	}
	
	
	@Override
	public String getplatformVersion() {
		return properties.getProperty("");
		
	}
	
	@Override
	public String getUrl() {
		return properties.getProperty("url");
	}

	
	@Override
	public String getBrowser() {
		return properties.getProperty("browser");
	}

	
	@Override
	public int getPageLoadTimeOut() {
		return Integer.parseInt(properties.getProperty("PageLoadTimeOut"));
	}

	
	@Override
	public String getUsername() {
		return properties.getProperty("username");	
	}

	
	@Override
	public String getPassword() {
		return properties.getProperty("password");
	}

	
	@Override
	public String getProduct() {
		return properties.getProperty("product");	
	}

	
}
