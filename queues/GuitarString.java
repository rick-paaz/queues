import model.Queue210;

public class GuitarString {

  private Queue210<Double> buffer;
  private int tic;
  private int capacity;

  /**
   * This constructor is supplied for the purpose of testing. You know exactly the
   * elements to be added to the Queue because you have to supply a completely
   * initialized double[]. This constructor creates an Queue of capacity equal to
   * the size of the array, and initializes the contents of the buffer to the
   * values in the array.
   */
  public GuitarString(double[] init) {
    capacity = init.length;
    buffer = new Queue210<Double>(capacity);
    for (int i = 0; i < init.length; i++) {
      buffer.enqueue(init[i]);
    }
  }

  /**
   * The constructor creates a Queue with the capacity of the Queue as the
   * samplingRate divided by the frequency and rounded UP the nearest whole
   * number. Once the Queue is created, the Queue should be filled with 0's.
   */
  public GuitarString(double frequency) {
    capacity = (int) Math.ceil(44100 / frequency);
    buffer = new Queue210<Double>(capacity);
    while (!buffer.isFull())
      buffer.enqueue(0.0); // fill buffer with 0s
    tic = 0;
  }

  /**
   * Replace all the items in the Queue with random values between -0.5 and +0.5.
   */
  public void pluck() {
    while (buffer.size() > 0)
      buffer.dequeue();
    setBufferToRandomDistancesFromAGuitarString();
  }

  private void setBufferToRandomDistancesFromAGuitarString() {
    for (int i = 1; i <= capacity; i++)
      buffer.enqueue(Math.random() - 0.5);
  }

  /**
   * Apply the Karplus-Strong update. To do this, remove the sample at the front
   * of the Queue. Use the sample that was removed and the sample that is now
   * at the front of the Queue and find their average. Multiply the average
   * of these two numbers with the energy decay factor. The energy decay factor is
   * 0.996. Then, place the result at the end of the Queue.
   */
  public void tic() {
    double front = (double) buffer.dequeue();
    double toAdd = 0.996 * (front + (double) buffer.peek()) / 2.0;
    buffer.enqueue(toAdd);
    tic++;
  }

  /**
   * Return the value of the item at the front of this Queue
   */
  public double sample() {
    return (double) buffer.peek();
  }

  /**
   * Return the total number of times tic() was called on this instance. This is a
   * measure of how much time has elapsed.
   */
  public int time() {
    return tic;
  }

  /**
   * Return the value for the maximum capacity of the Queue
   */
  public int getCapacity() {
    return capacity;
  }
}
