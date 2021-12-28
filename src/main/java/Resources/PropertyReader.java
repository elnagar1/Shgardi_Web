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
	public String getR_User() {
		return properties.getProperty("r_user");
	}

	@Override
	public String getR_Password() {
		return properties.getProperty("r_password");
	}

	@Override
	public String getInValidMobile() {
		return properties.getProperty("invalid_phone");
	}

	@Override
	public String getValidUnregisteredPhone() {
		return properties.getProperty("un_register_phone");
	}

	@Override
	public String getBrowser() {
		return  properties.getProperty("browser");
	}

	@Override
	public String getInValidPassword() {
		return  properties.getProperty("invalid_password");
	}

	@Override
	public String getValidMobile() {
		return properties.getProperty("phone");
	}

	
	@Override
	public String getValidPassword() {
		return properties.getProperty("password");
	}



	
}
