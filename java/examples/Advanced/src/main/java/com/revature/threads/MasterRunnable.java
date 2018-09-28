package com.revature.threads;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.log4j.Logger;

import com.revature.collections.CollectionInitializer;
import com.revature.definition.Calculable;

/**
 * Spawns a group of threads which calculate over regular and synchronized objects.
 * 
 * It also keeps track of the current index of object being checked for other threads to join later and
 * holds the data as static fields.
 *
 * If you wanted to return an avarage, or return a value of calculation, you should use the
 * Callable<T> functional interface.
 */
public class MasterRunnable implements Runnable {
	private static Logger LOGGER = Logger.getLogger(MasterRunnable.class);
	
	/**
	 * Regular Calculables
	 */
	public static final List<Calculable> CALCULABLES;
	
	public static volatile int REGULAR_COUNT;
	
	/**
	 * Synchronized Calculables
	 */
	public static final List<Calculable> SYNCHRO_CALCULABLES;
	
	public static AtomicInteger SYNCHRO_COUNT = new AtomicInteger(0);
	
	/**
	 * You could get these lists with Serialization
	 */
	static {
		LOGGER.info("Initializing circle lists");
		CALCULABLES = CollectionInitializer.initializeSequentialList(false, false);
		SYNCHRO_CALCULABLES = CollectionInitializer.initializeSequentialList(true, true);
	}
	
	@Override
	public void run() {
		new CalculableThread(true).start();
		new CalculableThread(true).start();
		
		/*
		 * Adding more synchronized threads won't help
		 */
//		new CalculableThread(true).start();
//		new CalculableThread(true).start();

		new CalculableThread(false).start();
		new CalculableThread(false).start();
		
		/*
		 * Look what happens if we add more regular threads [time improves]
		 * 
		 * (Time will stop improving when you reach your CPU capacity).
		 */
//		new CalculableThread(false).start();
//		new CalculableThread(false).start();
	}
}
