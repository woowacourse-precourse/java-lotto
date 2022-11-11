package lotto;

public class BonusNumber {
  public String isValidBonusNumber(String number) {
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
    // 당첨번호와 중복되지 않도록 기능 추가
    return number;
  }

//  public boolean isNotWinningNumber(String number) {
//
//  }

  public static void main(String[] args) {
    BonusNumber bonusNumber = new BonusNumber();
    bonusNumber.isValidBonusNumber("242"); // 이럴 경우에 길이 검사가 먼저 일어남.. 고쳐야대~
  }
}
