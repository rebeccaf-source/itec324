package itec324;
/**
 * This class repeatedly removes a number from the stack
 * @author Rebecca Fonseth
 * @version 1.0
 *
 */
public class Consumer implements Runnable {
	private SynchronizedBoundedStack stack;
	private int count;
	private static final int DELAY = 10;

	/**
	 * This is the value constructor for the Consumer class
	 * @param stack the stack that we will be using to get values
	 */
	public Consumer(SynchronizedBoundedStack stack, int count) {
		this.stack = stack;
		this.count = count;
	}

	/**
	 * What the threads will do when started
	 */
	@Override
	public void run() {
		int i = 1;
		while (i <= 1) {
			try {
				stack.setCount(count);
				int num = stack.pop();
				//System.out.println("Consumer " + count + " popped: " + num );//+ "\n" + this.stack.printStack());
				Thread.sleep((int) (Math.random() * DELAY));
			} catch (InterruptedException e) {
				System.out.println("Consumer interrupted, going to terminate");
			}
		}

	}

}
