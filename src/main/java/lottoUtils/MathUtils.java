package lottoUtils;

public class MathUtils {


  public static int numberOfLotto(int money) {

    int ticket = money / 1000;
    return ticket;
  }

  public static double calcYield(int reward, int money) {

    if (reward == 0)
      return 0;
    double yield = (double) reward / (double) money * 100;
    return yield;
  }
}
