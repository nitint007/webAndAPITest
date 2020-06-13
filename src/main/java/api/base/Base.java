/**
 * Parent class for all classes used under API automation suite
 */
package api.base;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * @author nitinthite
 * Class with custom constructor to initialise objects for properties used in child classes
 */
public class Base {
	
	public static Properties properties;
	
		// Class constructor for initialising objects
		public Base() throws FileNotFoundException, IOException {
			
			// To read file line by line
			BufferedReader reader;
			try {
				String configFilePath = "./src/test/resources/testdataresources/configData/api/Config.properties";
				reader = new BufferedReader(new FileReader(configFilePath));
				properties = new Properties();
				properties.load(reader);
			} catch (FileNotFoundException fnfe) {
				fnfe.printStackTrace();
				throw new RuntimeException("File Config.properties not found at given path.");
			} catch (IOException ioe) {
				ioe.printStackTrace();
				throw new RuntimeException("Issue on reading file.");
			}
		}
}
