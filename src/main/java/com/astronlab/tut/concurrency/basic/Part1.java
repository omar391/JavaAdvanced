package com.astronlab.tut.concurrency.basic;

/*
Introductions
======================
  Java included high-level concurrency APIs from JDK 5.0

 Concurrency Models:
-------------------------
	These following models are adhered in various software systems. Just to let us their names -

	1. Threaded model (Used in JAVA)
	2. Reactive & Event Driven Systems
	3. Actors & Channels

Concurrency Vs Parallelism
------------------------------
	Concurrency means that an application is making progress on more than one task at the same time (concurrently).
	Parallelism on the other hand, is related to how an application handles each individual task. An application may process the task serially from start to end, or split the task up into subtasks which can be completed in parallel.

	As you can see, an application can be concurrent, but not parallel. This means that it processes more than one task at the cognate time, but the tasks are not broken down into subtasks.
	An application can also be parallel but not concurrent. This means that the application only works on one task at a time, and this task is broken down into subtasks which can be processed in parallel.

	Additionally, an application can be neither concurrent nor parallel. This means that it works on only one task at a time, and the task is never broken down into subtasks for parallel execution.
	Finally, an application can also be both concurrent and parallel, in that it both works on multiple tasks at the cognate time, and also breaks each task down into subtasks for parallel execution.

  Multithreading Costs
-----------------------
 -More complex design
  :: Code executed by multiple threads accessing shared data need special attention
 -Context Switching Overhead
  ::When a CPU switches from executing one thread to executing another, the CPU needs to save the local data, program pointer etc. of the current thread, and load the local data, program pointer etc. of the next thread to execute.
 -Increased Resource Consumption


Ways to create a thread
==================================
 1. Via extending Thread class
 2. Via anonymous thread class
 3. Via Runnable interface

 Notes:
 -----------
 - Thread execution order is not guaranteed
 - Run the code multiple time to check the varying exec order
 - We must call "start()" method to init a thread
 - We could use thread names in thread constructors

* */

public class Part1 {
	private Part1(){}

	public static void main(String[] args) {

		//Way 1
		MyThread myThread = new MyThread(
				"Thread 1");//this could be without any constructor
		myThread.start();

		//Way 2
		Thread thread = new Thread() {
			@Override public void run() {
				System.out.println("Thread 2 running");
			}
		};
		thread.start();

		//Way 3
		thread = new Thread(new MyRunnable());
		thread.start();
	}

}

class MyThread extends Thread {
	public MyThread() {
		super();
	}

	public MyThread(String s) {
		super(s);
	}

	public void run() {
		System.out.println(this.getName() + " running");
	}
}

class MyRunnable implements Runnable {
	public void run() {
		System.out.println("Thread 3 running");
	}
}