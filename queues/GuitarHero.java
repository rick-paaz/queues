
/**
 * This file need no changes. When you get 100% on WebCat, uncomment 
 * this file and you will be able to play Guitar Hero on your keyboard.
 */
public class GuitarHero {

  public static void main(String[] args) {
    int NUM_KEYS = 37;
    int CONCERT_A = 440;
    String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";

    GuitarString[] note = new GuitarString[NUM_KEYS];
    for (int i = 0; i < NUM_KEYS; i++) {
      note[i] = new GuitarString(CONCERT_A * Math.pow(2, (i - 24) / 12.0));
//      System.out.println(CONCERT_A * Math.pow(2, (i - 24) / 12.0) + " " + note[i].getCapacity() ); 
    }

    while (true) {

      if (StdDraw.hasNextKeyTyped()) {

        char key = StdDraw.nextKeyTyped();

        int index = keyboard.indexOf(key);
        if (index != -1) {
          note[index].pluck();
        }
      }

      double sample = 0;
      for (int i = 0; i < NUM_KEYS; i++)
        sample += note[i].sample();

      StdAudio.play(sample);

      for (int i = 0; i < NUM_KEYS; i++)
        note[i].tic();
    }
  }
}