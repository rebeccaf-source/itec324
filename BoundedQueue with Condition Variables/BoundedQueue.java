
import java.util.concurrent.locks.*;

/**
 * A first-in, first-out bounded collection of objects.
 * @author Rebecca Fonseth
 * @version 2.0
 *
 * @param <E> The generic element type for the queue
 */
public class BoundedQueue<E> {
	/**
	 * Constructs an empty queue.
	 * 
	 * @param capacity the maximum capacity of the queue
	 */
	public BoundedQueue(int capacity) {
		elements = new Object[capacity];
		head = 0;
		tail = 0;
		size = 0;
		turn = false;
	}

	/**
	 * Removes the object at the head.
	 * 
	 * @return the object that has been removed from the queue
	 */
	public E remove() throws InterruptedException {
		queueLock.lock();
		try {
			while (!turn) {
				valueAvailableCondition.await();
			}
			E r = (E) elements[head];
			head++;
			size--;
			if (head == elements.length)
				head = 0;
			System.out.println("Consumer read:" + r);
			turn = false;
			spaceAvailableCondition.signalAll();
			return r;
		} finally {
			queueLock.unlock();
		}
	}

	/**
	 * Appends an object at the tail.
	 * 
	 * @param newValue the object to be appended
	 */
	public void add(E newValue) throws InterruptedException {
		queueLock.lock();
		try {
			while (turn) {
				spaceAvailableCondition.await();
			}
			elements[tail] = newValue;
			tail++;
			size++;
			if (tail == elements.length)
				tail = 0;
			System.out.println("Producer wrote:" + newValue);
			turn = true;
			valueAvailableCondition.signalAll();
			
		} finally {
			queueLock.unlock();
		}
	}

	private Object[] elements;
	private int head;
	private int tail;
	private int size;
	private boolean turn;

	private Lock queueLock = new ReentrantLock();
	private Condition spaceAvailableCondition = queueLock.newCondition();
	private Condition valueAvailableCondition = queueLock.newCondition();
}