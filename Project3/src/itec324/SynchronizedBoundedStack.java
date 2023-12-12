package itec324;

import java.util.concurrent.locks.Condition; 
import java.util.concurrent.locks.ReentrantLock;
/**
 * The bounded first-in-last-out collection of integers
 * @author Rebecca Fonseth
 *
 */
public class SynchronizedBoundedStack extends BoundedStack {
	// variables from the abstract class
	// protected final int capacity;
	// protected final int[] elements;
	// protected int top;

	private int count;
	private ReentrantLock aLock = new ReentrantLock();
	private Condition spaceAvailable = aLock.newCondition();
	private Condition valueAvailable = aLock.newCondition();

	/**
	 * Constructor for the stack
	 * @param capacity the size of the stack
	 */
	public SynchronizedBoundedStack(int capacity) {
		super(capacity);
	}

	/**
     * Pushes the provided element onto the top of the stack.
     * @param t : The item to push.
     */
	@Override
	public void push(int t) throws InterruptedException {
		aLock.lock();
		try {
			while(this.isFull()) {
				spaceAvailable.await();
			}
			super.elements[super.top] = t;
			super.top++;
			System.out.println("Producer " + count + " pushed: " + t);
			System.out.println(this.printStack());
			valueAvailable.signalAll();
		} finally {
			aLock.unlock();
		}

	}
	
	/**
     * Removes the top value from the stack and returns it.
     * @return : The item popped from the stack.
     */
	@Override
	public int pop() throws InterruptedException {
		aLock.lock();
		try {
			while(this.isEmpty()) {
				valueAvailable.await();
			}
			int t = super.elements[super.top - 1];
			super.elements[super.top - 1] = 0;
			super.top--;
			System.out.println("Consumer " + count + " popped: " + t);
			System.out.println(this.printStack());
			spaceAvailable.signalAll();
			return t;
		} finally {
			aLock.unlock();
		}
	}

	/**
     * Returns true if the stack is empty and false otherwise.
     * @return : Whether the stack is empty.
     */
	@Override
	public boolean isEmpty() {
			if (super.top == 0) {
				return true;
			}
			return false;

	}

	/**
     * Returns true if the stack is full, and false otherwise.
     * @return : Whether or not the stack is full.
     */
	@Override
	public boolean isFull() {

		if (super.top == super.capacity) {
			return true;
		}
		return false;
		
	}

	/**
	 * Returns the number of elements currently on the stack.
	 * 
	 * @return : The size of the stack.
	 */
	@Override
	public int getSize() {
		return super.top;
	}

	/**
	 * Prints the content of the stack
	 * 
	 * @return the content of the stack
	 */
	public String printStack() {
		aLock.lock();
		try {

			int[] temp = super.elements;
			String ans = "Stack content: ";
			for (int i = 0; i < this.getSize(); i++) {
				ans += temp[i] + " ";
			}
			return ans;
		} finally {
			aLock.unlock();
		}
	}
	
	/**
	 * sets the count of the producer or consumer (says which one it is)
	 * @param count which producer/consumer it is
	 */
	public void setCount(int count) {
		this.count = count;
	}
}
