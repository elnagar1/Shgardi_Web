package Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class PathHelper {
	

	
	public static String getResourcePath(String path){
		return System.getProperty("user.dir")+path;
	}
	
	
	public static FileInputStream getInputStreamResourcePath(String path) throws FileNotFoundException{
		return new FileInputStream(getResourcePath(path));
		
	}
	public static void main(String[] args) throws FileNotFoundException{
		System.out.println(getInputStreamResourcePath("/src/main/java/ConfigurationFile/config.properties"));
	}

}
