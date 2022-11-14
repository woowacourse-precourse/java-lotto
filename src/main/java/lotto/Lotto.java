package lotto;

import java.util.List;

public class Lotto {
  private static final int NUMBER_COUNT = 6;
  private static final int MIN_NUMBER = 1;
  private static final int MAX_NUMBER = 45;
  private final List<Integer> numbers;

  public Lotto(List<Integer> numbers) {
    validate(numbers);
    this.numbers = numbers;
  }

  private void validate(List<Integer> numbers) {
    checkNumbersCount(numbers);
    checkHasDuplicateNumber(numbers);
    checkIsNumbersInRange(numbers);
  }

  private void checkNumbersCount(List<Integer> numbers) {
    if (numbers.size() != NUMBER_COUNT) {
      throw new IllegalArgumentException("숫자의 개수가 잘못되었습니다!");
    }
  }

  private void checkHasDuplicateNumber(List<Integer> numbers) {
    if(numbers.stream().distinct().count() != numbers.size()) {
      throw new IllegalArgumentException("중복되는 숫자가 있습니다!");
    }
  }

  private void checkIsNumbersInRange(List<Integer> numbers) {
    for (int number : numbers) {
      if(!isInRange(number)){
        throw new IllegalArgumentException("범위를 벗어나는 숫자가 있습니다!");
      }
    }
  }

  private boolean isInRange(int number){
    return number >= MIN_NUMBER && number <= MAX_NUMBER;
  }
}
