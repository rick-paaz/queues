import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Queue210;

public class GuitarStringTest {
  
  @Test
  public void testToMakeSureYourArayRingBufferCanBeSetToAnyCapacity() {
    // If the next statement does not compile, change the constructor in Queue 
    // to take an int for initial capacity.  This code is needed Spring 2015 because Rick 
    // accidentally did not include the need a constructor that must specify the capacity 
    //  of an Queue with an int argument. If this is an error, add the parmameter.  
    Queue210<Double> buffer = new Queue210<>(10);
    assertEquals(0, buffer.size());
  }
  
  @Test
  public void testToShowMostMethods() {
    double[] init = { -0.2, 0.4, 0.3, 0.0, -0.1 };
    GuitarString  gs = new GuitarString(init);
    assertEquals(5, gs.getCapacity()); 

    assertEquals(-0.2, gs.sample(), 0.0001); 
    assertEquals(0, gs.time()); 
    gs.tic();
    assertEquals(1, gs.time()); 
    assertEquals(0.4, gs.sample(), 0.0001); 
  }


  @Test
  public void testConstructorWithAnArrayOfDouble() {
    double[] init = { 0.33, 0.4, 0.5, 0.3, -0.2, 0.4, 0.3, 0.0, -0.1, -0.3 };
    GuitarString gs = new GuitarString(init);
    assertEquals(0.33, gs.sample());
    assertEquals(10, gs.getCapacity());
  }

  @Test
  public void testGetters() {
    double[] init = { -0.2, 0.4, 0.3, 0.0, -0.1 };
    GuitarString gs = new GuitarString(init);
    gs.pluck();
    assertEquals(5, gs.getCapacity());
  }

  @Test
  public void testCapacityConstructorWithFrequencyArgumentNoArray() {
    GuitarString gs = new GuitarString(4000.0);
    assertEquals(12, gs.getCapacity());

    GuitarString gs2 = new GuitarString(8000.0);
    assertEquals(6, gs2.getCapacity());
  }

  @Test
  public void testTicWithTimeSimpleIncrement() {
    double[] init = { 0.4, 0.0, 2.0, -4.0 };
    GuitarString gs = new GuitarString(init);
    assertEquals(0, gs.time());
    gs.tic();
    assertEquals(1, gs.time());
    gs.tic();
    assertEquals(2, gs.time());
    gs.tic();
    assertEquals(3, gs.time());
    gs.tic();
    assertEquals(4, gs.time());
  }

  @Test
  public void testTicNTimesToAssertAllRingBufferElementsAreCorrect() {
    double[] init = { 0.4, 0.0, 2.0, -4.0 };
    GuitarString gs = new GuitarString(init);
    assertEquals(0, gs.time());
    gs.tic();
    assertEquals(1, gs.time());
    gs.tic();
    assertEquals(2, gs.time());
    gs.tic();
    assertEquals(3, gs.time());
    gs.tic();
    assertEquals(4, gs.time());
  }

  @Test
  public void testTicChangesAllBufferElementsOnceWithTic() {

    int N = 20; // runtime from user
    double[] samples = { 0.2, 0.4, 0.5, 0.3, -0.2, .4, 0.3, 0.0, -0.1, -0.3 };
    GuitarString testNote = new GuitarString(samples);
    double[] result = new double[N];
    for (int i = 0; i < N; i++) {
      result[i] = testNote.sample();
      testNote.tic();
    }

    // No change to the first 10
    assertEquals(0.2, result[0]);
    assertEquals(0.4, result[1]);
    assertEquals(-0.1, result[8]);
    assertEquals(-0.3, result[9]);

    // Any expected value that follows had the average * 0.996 applied
    assertEquals(0.2988, result[10]);
    assertEquals(0.4482, result[11]);
    assertEquals(0.3984, result[12]);
    assertEquals(0.0498, result[13]);
    assertEquals(0.0996, result[14]);
    assertEquals(0.3486, result[15]);
    assertEquals(0.1494, result[16]);
    assertEquals(-0.0498, result[17]);
    assertEquals(-0.1992, result[18]);
    assertEquals(-0.0006, result[19]);
  }

  @Test
  public void testTicChangesAllBufferElementsChangeFiveTimesInTic() {

    int N = 50; // runtime from user
    double[] samples = { 0.2, 0.4, 0.5, 0.3, -0.2, .4, 0.3, 0.0, -0.1, -0.3 };
    GuitarString testNote = new GuitarString(samples);
    double[] result = new double[N];
    for (int i = 0; i < N; i++) {
      result[i] = testNote.sample();
      testNote.tic();
    }

    // No change to the first 10
    assertEquals(0.2, result[0]);
    assertEquals(0.4, result[1]);
    assertEquals(-0.1, result[8]);
    assertEquals(-0.3, result[9]);

    // Any expected value that follows had the average * 0.996 applied
    // These values exist after going through the buffer 5 times.
    assertEquals(-0.0739, result[46]);
    assertEquals(-0.0342, result[47]);
    assertEquals(0.1651, result[48]);
    assertEquals(0.3215, result[49]);
  }

  @Test
  public void testConstructorWithOneFrequency() {
    GuitarString gs = new GuitarString(4000);
    assertEquals(0, gs.time());
    gs.pluck();
    for (int i = 0; i < 10; i++) {
      System.out.println(gs.sample());
      gs.tic();
    }
  }

}