package lotto.tool;

import java.util.HashSet;
import java.util.List;

public class InputChecker {

  private static final int LENGTH_LIMIT = 6;
  private static final int MIN_LOTTO_NUMBER = 1;
  private static final int MAX_LOTTO_NUMBER = 45;

  //입력값이 숫자인지
  public static void checkIsNumber(String input, InputType inputType)
      throws IllegalArgumentException {
    if (!input.matches("^[0-9]+$")) {
      throw new IllegalArgumentException(inputType.getText() + " 숫자여야 한다.");
    }
  }

  public static void checkIsNumber(String[] numberList, InputType inputType)
      throws IllegalArgumentException {
    for (int i = 0; i < numberList.length; i++) {
      if (!numberList[i].matches("^[0-9]+$")) {
        throw new IllegalArgumentException(inputType.getText() + " 숫자여야 한다.");
      }
    }
  }

  //입력값이 1~45 사이의 수인지
  public static void checkInRangeNumber(int number, InputType inputType)
      throws IllegalArgumentException {
    if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
      throw new IllegalArgumentException(
          inputType.getText() + " " + MIN_LOTTO_NUMBER + "과 " + MAX_LOTTO_NUMBER + " 사이의 숫자여야 한다.");
    }
  }

  public static void checkInRangeNumber(List<Integer> numberList, InputType inputType)
      throws IllegalArgumentException {
    for (int i = 0; i < numberList.size(); i++) {
      if (numberList.get(i) < MIN_LOTTO_NUMBER || numberList.get(i) > MAX_LOTTO_NUMBER) {
        throw new IllegalArgumentException(
            inputType.getText() + " " + MIN_LOTTO_NUMBER + "과 " + MAX_LOTTO_NUMBER
                + " 사이의 숫자여야 한다.");
      }
    }

  }

  //수가 1000으로 나누어떨어지는지
  public static void checkDivideThousand(int number, InputType inputType)
      throws IllegalArgumentException {
    if (number % 1000 != 0) {
      throw new IllegalArgumentException(inputType.getText() + " 1000으로 나누어 떨어져야 한다.");
    }
  }

  //리스트의 크기가 제약사항에 부합하는지
  public static void checkListSize(String[] inputList, InputType inputType)
      throws IllegalArgumentException {
    if (inputList.length != LENGTH_LIMIT) {
      throw new IllegalArgumentException(inputType.getText() + " 6개를 입력해야 한다.");
    }
  }

  //리스트의 중복된 값이 있는지
  public static void checkDuplicate(List<Integer> numberList, InputType inputType)
      throws IllegalArgumentException {
    HashSet<Integer> dpList = new HashSet<>();
    for (int i : numberList) {
      if (numberList.indexOf(i) != numberList.lastIndexOf(i)) {
        dpList.add(i);
      }
    }
    if (dpList.size() > 0) {
      throw new IllegalArgumentException(inputType.getText() + " 중복되어선 안된다.");
    }
  }

  public static void checkDuplicate(List<Integer> numberList, int bonnusNumber, InputType inputType)
      throws IllegalArgumentException {
    if (numberList.contains(bonnusNumber)) {
      throw new IllegalArgumentException(inputType.getText() + " 중복되어선 안된다.");
    }
  }
}
