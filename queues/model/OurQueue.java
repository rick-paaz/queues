package model;


public interface OurQueue<Type> {
  
	/**
	 * The size() method returns the number of elements currently in this Queue
	 */
	public int size();

	/**
	 * Returns true if the Queue is empty
	 */
	public boolean isEmpty();

	/**
	 * Returns true if the Queue is full
	 */
	public boolean isFull();

	/**
	 * This method puts element x into the Queue. Since the Queue is a
	 * queue, the element being inserted should be added to the end of the queue
	 * dequeue throws an CapacityException when the queue is full.
	 */
	public void enqueue(Type x);

	/**
	 * Removes the first element from the Queue and returns it.
	 * dequeue throws an CapacityException when the queue is empty.
	 */
	public Type dequeue() throws CapacityException;

	/**
	 * Returns the first element from the Queue and does NOT remove it from this Queue
   * peek() throws an CapacityException when the queue is empty.
	 */
	public Type peek();
}