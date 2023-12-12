package itec324;
/**
 *  An action that repeatedly inserts a number into the stack.
 * @author Rebecca Fonseth
 * @version 1.0
 *
 */
public class Producer implements Runnable {
	private SynchronizedBoundedStack stack;
	private int t;
	private int count;
	private static final int DELAY = 10;

	/**
	 * Constructor class for Producers
	 * @param t the value that is being pushed into the stack
	 * @param stack the stack that we are pushing objects onto
	 */
	public Producer(int t, SynchronizedBoundedStack stack, int count) {
		this.t = t;
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
				this.stack.push(t);
				//System.out.println("Producer " + count + " pushed: " + t); //+ "\n" + this.stack.printStack());
				this.t++;
				Thread.sleep((int) (Math.random() * DELAY));
			} catch (InterruptedException e) {
				System.out.println("Producer interrupted, going to terminate");
			}

		}

	}

}
