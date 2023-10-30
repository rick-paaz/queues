package model;

/**
 * You can now use this code in Queue: throw new CapacityException();
 * 
 * @author mercer
 */
public class CapacityException extends RuntimeException {
  public CapacityException() {
    super(
        "You either tried to enqueue to a full Queue210 or peeked or dequeued an empty Queue210");
  }
}