package GenericUtils;

import java.util.Random;

public class RandomNum
{
	public int getRandomNo()
	{
		Random ran = new Random();
		int random = ran.nextInt(500);
		return random;
	}
}