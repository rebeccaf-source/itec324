/**
 * This program runs two threads in parallel.
 * @author Rebecca Fonseth
 * @version 2.0
 */
 public class ThreadTester
 {
	 /**
	  * The main method for the thread tester
	  * 
	  * @param args command line arguments that will never be used
	  */
    public static void main(String[] args)
    {
       BoundedQueue<String> queue = new BoundedQueue<String>(10);
       final int GREETING_COUNT = 5;
       Runnable run1 = new Producer("Hello, World!", 
             queue, GREETING_COUNT);
       Runnable run2 = new Producer("Goodbye, World!", 
             queue, GREETING_COUNT);
       Runnable run3 = new Consumer(queue, 2 * GREETING_COUNT);
       Runnable run4 = new Consumer(queue, 2 * GREETING_COUNT);
       
       
       Thread thread1 = new Thread(run1);
       Thread thread2 = new Thread(run2);
       Thread thread3 = new Thread(run3); 
       Thread thread4 = new Thread(run4);
       
 
       thread1.start();
       thread2.start();
       thread3.start();
       thread4.start();
       
       //thread3.interrupt();
       
    }
 }