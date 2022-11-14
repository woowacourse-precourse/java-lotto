package lotto;

import java.util.List;

import static lotto.LottoValidator.*;

public class Lotto {
  public static final int NUMBER_COUNT = 6;
  public static final int MIN_NUMBER = 1;
  public static final int MAX_NUMBER = 45;
  public static final int PRICE = 1000;
  private final List<Integer> numbers;

  public Lotto(List<Integer> numbers) {
    validate(numbers);
    this.numbers = numbers;
  }
}
