package generic.fileutility;

import java.io.FileInputStream;
import java.util.Properties;

import generic.IConstantPath.IconstantPath;
/**
 * 
 * @author Gulshan
 *
 */
public class FileUtility implements IconstantPath {
	/**
	 * used to read the data from propertied file based on key
	 * @param key
	 * @return
	 * @throws Throwable
	 */
	public String getDataFromPropertiesFile(String key) throws Throwable {
		
		FileInputStream fis = new FileInputStream(PROP_PATH);
		Properties pObj = new Properties();
		pObj.load(fis);
		String data = pObj.getProperty(key);
		
		return data;
	}

}
