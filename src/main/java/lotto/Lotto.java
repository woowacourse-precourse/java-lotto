package lotto;

import java.util.List;

public class Lotto {
  private static final int NUMBER_COUNT = 6;
  private final List<Integer> numbers;

  public Lotto(List<Integer> numbers) {
    validate(numbers);
    this.numbers = numbers;
  }

  private void validate(List<Integer> numbers) {
    checkNumbersCount(numbers);
    checkHasDuplicateNumber(numbers);
  }

  private void checkNumbersCount(List<Integer> numbers) {
    if (numbers.size() != NUMBER_COUNT) {
      throw new IllegalArgumentException("로또 숫자의 개수가 잘못되었습니다!");
    }
  }

  private void checkHasDuplicateNumber(List<Integer> numbers) {
    if(numbers.stream().distinct().count() != numbers.size()) {
      throw new IllegalArgumentException("로또 숫자의 개수가 잘못되었습니다!");
    }
  }
}
