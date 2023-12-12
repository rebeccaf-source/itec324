package itec324;
/**
 * This program runs four threads in parallel
 * @author Rebecca Fonseth
 *
 */
public class ThreadRunner 
{
	/**
	 * The main method for the thread runner class
	 * 
	 * @param args command line arguments that will never be used
	 */
	public static void main(String[] args)
	{
		SynchronizedBoundedStack stack = new SynchronizedBoundedStack(10);
		//making the runnables
		Runnable p1 = new Producer(1, stack, 1);
		Runnable p2 = new Producer(101, stack, 2);
		Runnable c1 = new Consumer(stack, 1);
		Runnable c2 = new Consumer(stack, 2);
		//making the threads
		Thread one = new Thread(p1);
		Thread two = new Thread(p2);
		Thread three = new Thread(c1);
		Thread four = new Thread(c2);
		//Starting the threads
		one.start();
		two.start();
		three.start();
		four.start();

		
	}
}
