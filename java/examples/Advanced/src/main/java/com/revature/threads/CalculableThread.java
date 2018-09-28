package com.revature.threads;

/**
 * Static imports to MasterRunnable call
 */
import static com.revature.threads.MasterRunnable.CALCULABLES;
import static com.revature.threads.MasterRunnable.REGULAR_COUNT;
import static com.revature.threads.MasterRunnable.SYNCHRO_CALCULABLES;
import static com.revature.threads.MasterRunnable.SYNCHRO_COUNT;

import org.apache.log4j.Logger;

/**
 * This threads operates and prints all calculations of shapes within a List.
 *
 */
public class CalculableThread extends Thread {	
	private static final Logger LOGGER = Logger.getLogger(CalculableThread.class);

	private boolean useSynchroList;

	public CalculableThread(boolean useSynchroList) {
		this.useSynchroList = useSynchroList;
	}

	@Override
	public void run() {
		String threadName = this.getName();
		long start = System.currentTimeMillis();

		if(!useSynchroList) {
			threadName += "_Regular";
			while(true) {
				/*
				 * If you uncomment the synchronized block, you can definetely see the disorder.
				 * 
				 * With synchronization you can make multiple threads harmonize without competing, but your actions in this case
				 * are not fully thread-safe.
				 * 
				 * With synchronized block, the Regular_Team takes almost the same time as fully synchronized.
				 * 
				 * -> When two threads have poorly written nested synchronized blocks, a deadlock can happen.
				 */
//				synchronized(SYNCHRO_CALCULABLES) {
//					synchronized(CALCULABLES) {
						try {
							LOGGER.info(threadName + " area (Circle " + Integer.sum(REGULAR_COUNT, 1) + "): " + CALCULABLES.get(REGULAR_COUNT).area());
							LOGGER.info(threadName + " perimeter (Circle " + Integer.sum(REGULAR_COUNT, 1) + "): " + CALCULABLES.get(REGULAR_COUNT).perimeter());
							REGULAR_COUNT++;
						} catch (IndexOutOfBoundsException e) {
							/*
							 * If we finished calculation, kill Daemon
							 */
							break;
						}
//					}
//				}
			}			
		} else {
			threadName += "_Synchro";
			while(true) {
				/*
				 * The only way to guarantee order of execution is with a synchronized block.
				 * 
				 * Even using AtomicInteger, Vector, and ConcurrentCircle, our actions are thread-safe
				 * but that doesn't mean that the order will be guaranteed.
				 * 
				 * What is proven, is that execution is slower.
				 */
				//synchronized(CALCULABLES) {
					synchronized(SYNCHRO_CALCULABLES) {
						try {
							LOGGER.info(threadName + " area (Circle " + Integer.sum(SYNCHRO_COUNT.get(), 1) + "): " + SYNCHRO_CALCULABLES.get(SYNCHRO_COUNT.get()).area());
							LOGGER.info(threadName + " perimeter (Circle " + Integer.sum(SYNCHRO_COUNT.get(), 1) + "): " + SYNCHRO_CALCULABLES.get(SYNCHRO_COUNT.get()).perimeter());
							SYNCHRO_COUNT.incrementAndGet();
						} catch (IndexOutOfBoundsException e) {
							/*
							 * If we finished calculation, kill Daemon
							 */
							break;
						}
					}
				//}
			}
		}
		long end = System.currentTimeMillis();
		long total = end - start;

		String team = (useSynchroList) ? "Synchronized Team":"Unsynchronized Team";
		LOGGER.warn(team + " took: " + total + " ms");
	}
}
