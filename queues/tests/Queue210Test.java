package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import model.OurQueue;
import model.Queue210;

public class Queue210Test {
   
  @Test
  public void testGettersWhenEmpty() {
    OurQueue <Double>buffer = new Queue210<>();
    assertTrue(buffer.isEmpty());
    assertFalse(buffer.isFull()); 
    assertEquals(0, buffer.size());
    buffer.enqueue(1.1);
    buffer.enqueue(2.2);
    assertEquals(2, buffer.size());
    assertEquals(1.1, buffer.peek());
    double front = buffer.dequeue();
    assertEquals(1.1, front);
    assertEquals(2.2, buffer.dequeue());
    assertTrue(buffer.isEmpty());
  }
}
