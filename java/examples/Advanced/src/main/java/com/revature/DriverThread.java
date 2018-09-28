package com.revature;

import com.revature.threads.MasterRunnable;

public class DriverThread {
	public static void main(String[] args) {
		/*
		 * Remember, the start method comes from the Thread class!
		 * 
		 * Runnable is a FUNCTIONAL interface which only holds run().
		 */
		new Thread(new MasterRunnable()).start();
	}
}
