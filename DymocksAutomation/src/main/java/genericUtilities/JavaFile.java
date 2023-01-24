/**
 * 
 */
package genericUtilities;

import java.util.Random;

/**
 * @author ManjuAnju
 * Contains java specific method which can be used across test scripts/ application
 */
public class JavaFile {
	public int getRandomNumber()
	{		
		Random ran = new Random();
		int ranNum = ran.nextInt();
		return ranNum;
	}
	

}
