package itec324;
/**
 * An abstract class that represents a stack of integers. 
 * All methods should be implemented in a thread-safe manner.
 */
/*
 * You must extend this class and implement the abstract methods in
 * such a fashion that all race conditions are avoided.
 */
public abstract class BoundedStack {

    /*
    Protected instance fields. Use these in your subclass's implementation.
     */

    /**
     * The maximum number of elements the stack can hold at a time.
     * Initialized in the constructor.
     */
    protected final int capacity;

    /**
     * An array holding the items on the stack.
     */
    protected final int[] elements;

    /**
     * Index of the next unoccupied location on the stack.
     */
    protected int top;

    /**
     * Constructor for a new BoundedStack object.
     * @param capacity : The capacity of this stack.
     */
    /*
     Override this constructor, and invoke super(), passing in the
     capacity.
     */
    public BoundedStack(int capacity) {
        this.capacity = capacity;
        this.elements = new int[capacity]; // Defaults to null value
        this.top = 0;
    }

    /**
     * Pushes the provided element onto the top of the stack.
     * @param t : The item to push.
     */
    public abstract void push(int t) throws InterruptedException;

    /**
     * Removes the top value from the stack and returns it.
     * @return : The item popped from the stack.
     */
    public abstract int pop() throws InterruptedException;

    /**
     * Returns true if the stack is empty and false otherwise.
     * @return : Whether the stack is empty.
     */
    public abstract boolean isEmpty();

    /**
     * Returns true if the stack is full, and false otherwise.
     * @return : Whether or not the stack is full.
     */
    public abstract boolean isFull();

    /**
     * Returns the number of elements currently on the stack.
     * @return : The size of the stack.
     */
    public abstract int getSize();

}
