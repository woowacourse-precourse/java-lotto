package lotto;

import java.util.ArrayList;
import java.util.List;

public class WinningNumber {
  private List<Integer> number;

  public WinningNumber(String userNumber) {
    this.number = splitNumber(userNumber);
  }
  // ','를 기준으로 split 시행
  public List<Integer> splitNumber(String userNumber) {
    String[] number = userNumber.split(",");
    List<Integer> numberInt = new ArrayList<>();
    for (String num : number) {
      onlyDigit(num);
      numberInt.add(Integer.parseInt(num));
    }
    return numberInt;
  }
// 유효성 검사
  public void onlyDigit(String num) {
    for (int i = 0; i < num.length(); i++) {
      if (!Character.isDigit(num.charAt(i))) {
        throw new IllegalArgumentException(ErrorMessage.NOT_ONLY_DIGIT.getMessage());
      }
    }
    int result = Integer.parseInt(num);
    isNumberInRange(result);
  }

  public void isNumberInRange(int num) {
    if (num > 45 || num < 1) {
      throw new IllegalArgumentException(ErrorMessage.NOT_RANGE_MESSAGE.getMessage());
    }
  }

  public List<Integer> getNumber() {
    return number;
  }
}


