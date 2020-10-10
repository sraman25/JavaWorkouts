package com.example.lambda;

import java.util.Calendar;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class artech {

	public static void main(String[] args) throws InterruptedException {
		
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(10);
        queue.add(20000);
        queue.add(1500);
        queue.add(1000);
        queue.add(500);
        queue.add(200);
        queue.add(200);
        
        BlockingQueue<Integer> queue1 = new ArrayBlockingQueue<Integer>(10);
        queue1.add(2000);
        queue1.add(1500);
        queue1.add(1000);
        queue1.add(500);
        queue1.add(200);
        queue1.add(200);
        
        
		ExecutorService executor = Executors.newScheduledThreadPool(5);
		for (int i = 0; i < 10; i++) {
			Runnable worker = new WorkerThread("" + i,queue);
			executor.execute(worker);
		}
		
		
		ExecutorService executor1 = Executors.newScheduledThreadPool(10);
		for (int i = 0; i < 10; i++) {
			Runnable worker = new WorkerThread("" + i,queue1);
			executor1.execute(worker);
		}
		
		
		executor.shutdown();
		while (!executor.isTerminated()) {
		}
		
		
		executor1.shutdown();
		while (!executor1.isTerminated()) {
		}
		System.out.println("Finished all threads");

	}
}

class WorkerThread implements Runnable {

	private String command;
	Integer time ;
    BlockingQueue<Integer> queue;
    Calendar calendar = Calendar.getInstance();

	public WorkerThread(String s,BlockingQueue<Integer> queue) {
		this.command = s;
		this.queue=queue;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " Start. Command = " + command);
		processCommand();
		System.out.println(Thread.currentThread().getName() + " End.");
	}

	private void processCommand() {
		while ((time = queue.poll()) != null) {
		try {
			 long st = System.currentTimeMillis();
			Thread.sleep(time);
			long en = System.currentTimeMillis();
			  System.out.println("Thread " + Thread.currentThread().getId() + " execution time " + time + " Job Number " + "To be added" + " start time " + st + " end time " + en + " Difference " + (en - st));

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		}
	}

	@Override
	public String toString() {
		return this.command;
	}
}