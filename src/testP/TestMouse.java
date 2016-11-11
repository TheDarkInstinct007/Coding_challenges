package testP;
import java.awt.Robot;
import java.awt.event.*;
import java.util.Timer;
import java.util.TimerTask;


public class TestMouse {
	public static void main(String args[])
	{
		try
		{
			Timer timer = new Timer();
			Robot bot = new Robot();
			bot.mouseMove(1780, 10);    
			bot.mousePress(InputEvent.BUTTON1_MASK);
			bot.mouseRelease(InputEvent.BUTTON1_MASK);  

			TimerTask timerTask = new TimerTask()
			{
				@Override
				public void run() {
					
					bot.mouseMove(95, 55);   
					bot.mousePress(InputEvent.BUTTON1_MASK);
					bot.mouseRelease(InputEvent.BUTTON1_MASK);  

				}
			};

			timer.scheduleAtFixedRate(timerTask, 3*60*1000, 3*60*1000);

		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}



}
