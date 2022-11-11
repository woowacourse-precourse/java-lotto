package lotto;

public class BonusNumber {
  public void isValidBonusNumber(String number) {
    int num = Integer.parseInt(number);
    if (number.length() > 2) {
      throw new IllegalArgumentException("[ERROR] 하나의 숫자만 입력해 주세요.");
    }
    for (int i = 0; i < number.length(); i++) {
      if (!Character.isDigit(number.charAt(i))) {
        throw new IllegalArgumentException(Constant.NOT_ONLY_DIGIT);
      }
    }
    if (num < 1 || num > 45) {
      throw new IllegalArgumentException(Constant.NOT_RANGE_MESSAGE);
    }
  }
}
