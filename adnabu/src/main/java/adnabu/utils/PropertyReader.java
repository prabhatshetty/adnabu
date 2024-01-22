package adnabu.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {

	/**
	 * This method is used to read the data from property file.
	 * @param path
	 * @param key
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public String readDataFromPropertyFile(String path ,String key) throws FileNotFoundException, IOException
	{
		Properties prop=new Properties();
		prop.load(new FileInputStream(path));
		String value=prop.getProperty(key);
		return value;
	}
	
}
