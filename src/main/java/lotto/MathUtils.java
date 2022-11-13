package lotto;

public class MathUtils {


  public static int numberOfLotto(int money) {
    int ticket = 0;

    ticket = money / 1000;
    return ticket;
  }

  public static double calcYield(int reward, int money) {
    double yield = 0;

    yield = money / reward * 100;
    return yield;
  }
}
