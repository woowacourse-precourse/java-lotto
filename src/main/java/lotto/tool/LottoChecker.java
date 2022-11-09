package lotto.tool;

import java.util.List;

public class LottoChecker {

  public static final int LENGTH_LIMIT = 6;
  public static final int MIN_LOTTO_NUMBER = 1;
  public static final int MAX_LOTTO_NUMBER = 45;

  //입력값이 숫자인지
  public static void checkIsNumber(String input)
      throws IllegalArgumentException {
    if (!input.matches("^[0-9]+$")) {
      throw new IllegalArgumentException("보너스 번호는 숫자여야 한다.");
    }
  }

  public static void checkIsNumber(String[] numberList)
      throws IllegalArgumentException {
    for (int i = 0; i < numberList.length; i++) {
      if (!numberList[i].matches("^[0-9]+$")) {
        throw new IllegalArgumentException("로또 번호는 숫자여야 한다.");
      }
    }
  }

  //입력값이 1~45 사이의 수인지
  public static void checkInRangeNumber(int number)
      throws IllegalArgumentException {
    if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
      throw new IllegalArgumentException("보너스 번호는 1과 45 사이의 숫자여야 한다.");
    }
  }

  //수가 1000으로 나누어떨어지는지
  public static void checkDivideThousand(int number)
      throws IllegalArgumentException {
    if (number % 1000 != 0) {
      throw new IllegalArgumentException("구입 금액은 1000으로 나누어 떨어져야 한다.");
    }
  }

  //리스트의 중복된 값이 있는지
  public static void checkDuplicate(List<Integer> numberList, int bonnusNumber)
      throws IllegalArgumentException {
    if (numberList.contains(bonnusNumber)) {
      throw new IllegalArgumentException("보너스 번호는 로또 번호와 중복되어선 안된다.");
    }
  }
}
