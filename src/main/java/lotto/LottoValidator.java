package lotto;

import lotto.exception.HasDuplicateException;
import lotto.exception.NumberOutOfRangeException;
import lotto.exception.WrongNumberCountException;

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
      throw new WrongNumberCountException();
    }
  }

  private static void checkHasDuplicateNumber(List<Integer> numbers) {
    if (numbers.stream().distinct().count() != numbers.size()) {
      throw new HasDuplicateException();
    }
  }

  private static void checkIsNumbersInRange(List<Integer> numbers) {
    for (int number : numbers) {
      checkIsNumberInRange(number);
    }
  }

  public static void checkIsNumberInRange(int number) {
    if (!isInRange(number)) {
      throw new NumberOutOfRangeException();
    }
  }

  private static boolean isInRange(int number) {
    return number >= MIN_NUMBER && number <= MAX_NUMBER;
  }
}
