
/**
 * An action that repeatedly inserts a greeting into a queue.
 * @author Rebecca Fonseth
 * @version 1.1
 */
 public class Producer implements Runnable
 {
    /**
       Constructs the producer object.
       @param aGreeting the greeting to insert into a queue
       @param aQueue the queue into which to insert greetings
       @param count the number of greetings to produce
    */
    public Producer(String aGreeting, BoundedQueue<String> aQueue, int count)
    {
       greeting = aGreeting;
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
             queue.add(i + ": " + greeting);
             //System.out.println("Producer wrote:" + greeting);
             i++;
             Thread.sleep((int) (Math.random() * DELAY));
          }
       }
       catch (InterruptedException exception)
       {
       }
    }
 
    private String greeting;
    private BoundedQueue<String> queue;
    private int greetingCount;
 
    private static final int DELAY = 10;
 }