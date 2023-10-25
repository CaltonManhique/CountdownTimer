package countdowntimer;

import java.util.concurrent.atomic.AtomicInteger;

public class Countdown implements Runnable {

	private AtomicInteger timer = new AtomicInteger();

	public Countdown(AtomicInteger timer) {
		this.timer = timer;
	}

	@Override
	public void run() {
		countdownTimer();
	}

	public void countdownTimer() {

		if (timer.get() > 0) {
			timer.decrementAndGet();
			System.out.println("Remaining time: " + timer.get());
		} else {
			System.out.println("Time's up!");
		}
	}
}
