package lotto.domain;

import lotto.view.ErrorMessage;

import java.util.*;

public class WinningNumber {
  private final List<Integer> number;

  public WinningNumber(String userNumber) {
    this.number = validWinningNumber(userNumber);
  }
  
  // ','를 기준으로 split 시행
  public List<Integer> validWinningNumber(String userNumber) {
    String[] number = userNumber.split(",");
    List<Integer> numberInt = new ArrayList<>();
    for (String num : number) {
      winningNumberisDigits(num);
      numberInt.add(Integer.parseInt(num));
    }
    sizeIsSix(numberInt);
    isDuplicateWinningNumber(numberInt);
    return numberInt;
  }

  public static void isDuplicateWinningNumber(List<Integer> numberInt) {
    Set<Integer> set = new HashSet<>(numberInt);
    if (numberInt.size() != set.size()) {
      throw new IllegalArgumentException(ErrorMessage.NOT_ONLY_WINNING_NUMBER.getMessage());
    }
  }

  public static void sizeIsSix(List<Integer> numberInt) {
    if (numberInt.size() != 6) {
      throw new IllegalArgumentException(ErrorMessage.NOT_SIX_NUMBERS.getMessage());
    }
  }
  
// 유효성 검사
  public void winningNumberisDigits(String num) {
    for (int i = 0; i < num.length(); i++) {
      if (!Character.isDigit(num.charAt(i))) {
        throw new IllegalArgumentException(ErrorMessage.NOT_ONLY_DIGIT.getMessage());
      }
    }
    int result = Integer.parseInt(num);
    isWinningNumberInRange(result);
  }

  public void isWinningNumberInRange(int num) {
    if (num > 45 || num < 1) {
      throw new IllegalArgumentException(ErrorMessage.NOT_RANGE_MESSAGE.getMessage());
    }
  }

  public List<Integer> getNumber() {
    return number;
  }
}


