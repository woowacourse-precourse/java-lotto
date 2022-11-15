package lotto;

import java.util.List;

import static lotto.Lotto.*;

public class LottoValidator {

  public static void validate(List<Integer> numbers) {
    checkNumbersCount(numbers);
    checkHasDuplicateNumber(numbers);
    checkIsNumbersInRange(numbers);
  }

  private static void checkNumbersCount(List<Integer> numbers) {
    if (numbers.size() != NUMBER_COUNT) {
      throw new IllegalArgumentException("[ERROR] 숫자의 개수가 잘못되었습니다.");
    }
  }

  private static void checkHasDuplicateNumber(List<Integer> numbers) {
    if (numbers.stream().distinct().count() != numbers.size()) {
      throw new IllegalArgumentException("[ERROR] 중복되는 숫자가 있습니다.");
    }
  }

  private static void checkIsNumbersInRange(List<Integer> numbers) {
    for (int number : numbers) {
      checkIsNumberInRange(number);
    }
  }

  public static void checkIsNumberInRange(int number) {
    if (!isInRange(number)) {
      throw new IllegalArgumentException("[ERROR] 범위를 벗어나는 숫자가 있습니다.");
    }
  }

  private static boolean isInRange(int number) {
    return number >= MIN_NUMBER && number <= MAX_NUMBER;
  }
}
