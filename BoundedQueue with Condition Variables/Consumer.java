/**
 * An action that repeatedly removes a greeting from a queue.
 * @author Rebecca Fonseth
 * @version 1.1
 *
 */
 public class Consumer implements Runnable
 {
    /**
       Constructs the consumer object.
       @param aQueue the queue from which to retrieve greetings
       @param count the number of greetings to consume
    */
    public Consumer(BoundedQueue<String> aQueue, int count)
    {
       queue = aQueue;
       greetingCount = count;
    }
    
    /**
	 * What the threads will do when started
	 */
    public void run()
    {
       try
       {
          int i = 1;
          while (i <= greetingCount)
          {
             String greeting = queue.remove();
             //System.out.println("Consumer read:" + greeting);
             i++;
             Thread.sleep((int) (Math.random() * DELAY));
          }
       }
       catch (InterruptedException exception)
       {
       }
    }
 
    private BoundedQueue<String> queue;
    private int greetingCount;
 
    private static final int DELAY = 10;
 }