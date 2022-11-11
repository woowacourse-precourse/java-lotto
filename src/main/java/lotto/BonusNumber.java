package lotto;

import java.util.List;

public class BonusNumber {
  public static int isValidBonusNumber(String number, List<Integer> winningNumber) {
    if (number.length() > 2) {
      throw new IllegalArgumentException("[ERROR] 하나의 숫자만 입력해 주세요.");
    }
    for (int i = 0; i < number.length(); i++) {
      if (!Character.isDigit(number.charAt(i))) {
        throw new IllegalArgumentException(ErrorMessage.NOT_ONLY_DIGIT.getMessage());
      }
    }
    int num = Integer.parseInt(number);
    if (num < 1 || num > 45) {
      throw new IllegalArgumentException(ErrorMessage.NOT_RANGE_MESSAGE.getMessage());
    }
    if (winningNumber.contains(num))
      throw new IllegalArgumentException("[ERROR] 당첨 번호와 중복되어 있습니다.");
    // 당첨번호와 중복되지 않도록 기능 추가
    return num;
  }
}
