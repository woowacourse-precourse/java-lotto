package lotto;

import lotto.money.Money;
import lotto.numbers.RandomNumberCreater;

import java.util.List;

public class LottoPirnt {
  public static void printPaper(List<Lotto> countLotto) {
    for (int j = 0; j < Money.count; j++) {
      Lotto lotto = countLotto.get(j);
      List<Integer> numbers = lotto.getNumbers();
      System.out.println(numbers);
    }
  }
}
