package lotto;

public class MathUtils {


  public static int numberOfLotto(int money) {
    int ticket = 0;

    ticket = money / 1000;
    return ticket;
  }

  public static double calcYield(int reward, int money) {
    double yield = 0;

    if (reward == 0)
      return 0;
    yield = (double)reward / (double)money;
    yield *= 100;
    return yield;
  }
}
