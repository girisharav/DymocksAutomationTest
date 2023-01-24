/**
 * 
 */
package genericUtilities;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * @author ManjuAnju
 * To read the values from property file containing URL and credentials.
 */
public class PropertyFile {
	
	public String getPropertydata(String key) throws Throwable
	{
		FileInputStream fis = new FileInputStream("./src/test/resources/DymocksCredentials.properties.txt");
		Properties pro = new Properties();
		pro.load(fis);
		String value = pro.getProperty(key);
		return value;
		
		
			
	}	  
}
