package GenericUtilities_API;

import java.util.Random;

public class JavaLibrary
{
	public int getRandomNo()
	{
		Random ran = new Random();
		int random = ran.nextInt(500);
		return random;
	}
}