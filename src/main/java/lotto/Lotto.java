package lotto;

import java.util.List;

import static lotto.LottoValidator.*;

public class Lotto {
  private final List<Integer> numbers;

  public Lotto(List<Integer> numbers) {
    validate(numbers);
    this.numbers = numbers;
  }
}
