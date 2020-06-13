/**
 * Package consists class to provide comparison details for URLs provided
 */
package api.comparator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import org.json.simple.parser.ParseException;

import api.base.Base;
import api.restapi.SendRequest;
import api.validator.ValidateURL;

/**
 * @author nitinthite
 * Class to implement methods to compare URL responses for equality
 */
public class ResponseComparator extends Base{
	
	// To make variables accessible for sub classes and packages
	protected String url1, url2, res1, res2;
	boolean result = false;

	
	public ResponseComparator() throws FileNotFoundException, IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	// To know comparison result - to assert comparison values further
	public boolean comparisonResult() {
		
		if (result == true) {
			
			System.out.println(url1 + "equals" + url2);
		}
		else {
			
			System.out.println(url1 + "Not equals" + url2);
		}
		return result;
	}
	
	
	// To compare responses from two urls provided
	public boolean compareResponses(String file1, String file2) throws IOException, ParseException, URISyntaxException, NoSuchElementException, IllegalStateException {
		
		String res1, res2;
		ValidateURL validateurl = new ValidateURL();
		
			try {
				// creates a new file instance
				File f1 = new File(file1.toString());
				File f2 = new File(file2.toString());
				
				Scanner sc1 = new Scanner(f1);  
				Scanner sc2 = new Scanner(f2);
				
				// To enter loop in case any one file has data next line
				while(sc1.hasNextLine() || sc2.hasNextLine()) {  
					
					// To store line content to string
					url1 = sc1.nextLine();
					url2 = sc2.nextLine();
					
					// To check if URL valid
					if (validateurl.isValidURL(url1) && validateurl.isValidURL(url2))
					{
						// To get the response
						SendRequest request = new SendRequest();
						// To store responses received from method
						res1 = request.getResponse(url1);
						res2 = request.getResponse(url2);
						
						System.out.println(url1 + (res1.contentEquals(res2) ? "" : " not ") + " equals " + url2);
						
						result = res1 == res2;
					}
					else {
						System.out.println("* * * One of URL to be compared IS NOT VALID");
						
						result = false;
					}
				}
			} 
			catch (IOException ioe) {
				ioe.printStackTrace();
				throw new RuntimeException("* * * * * Issue with file input");
			}
			catch (ParseException pe) {
				pe.printStackTrace();
				throw new RuntimeException("* * * * * Issue Parsing file");
			}
			catch (URISyntaxException urise) {
				urise.printStackTrace();
				throw new RuntimeException("* * * * * Issue URI syntax");
			}
			catch (NoSuchElementException nsee) {
				nsee.printStackTrace();
				throw new RuntimeException("* * * * * One of file under comparison has no more lines present");
			}
			catch (IllegalStateException nsee) {
				nsee.printStackTrace();
				throw new RuntimeException("* * * * * Target URL line is blank");
			}
			return result;
	}
}
