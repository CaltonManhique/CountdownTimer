package countdowntimer;

import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Timer {

	private Scanner scanner = new Scanner(System.in);
	private ScheduledExecutorService scheduledExecutor = Executors.newSingleThreadScheduledExecutor();
	private Runnable countdown;
	private AtomicInteger time;

	public void setTimmer() {
		System.out.println("Set timer:");
		try {
			int i = scanner.nextInt();
			time = new AtomicInteger(i);
		} catch (Exception e) {
			System.out.println("Invalid value! Please enter an integer.");
		}

		countdown = new Countdown(time);

		scheduledExecutor.scheduleAtFixedRate(countdown, 0, 1, TimeUnit.SECONDS);

		try {
			Thread.sleep(10000);
			scheduledExecutor.shutdown();

			scheduledExecutor.awaitTermination(11, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
