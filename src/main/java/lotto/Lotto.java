package lotto;

import java.util.Comparator;
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
    numbers.sort(Comparator.naturalOrder());
    this.numbers = numbers;
  }

  public String getLottoString() {
    return numbers.toString();
  }

  public List<Integer> getLottoNumbers() {
    return this.numbers;
  }

  public boolean isNumberContained(int number) {
    return numbers.contains(number);
  }
}
