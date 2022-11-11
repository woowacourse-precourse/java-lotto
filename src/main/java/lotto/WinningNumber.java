package lotto;

public class WinningNumber {
  // ','를 기준으로 split 시행
  public void splitNumber(String userNumber) {
    String[] number = userNumber.split(",");
    for (String num : number) {
      onlyDigit(num);
    }
  }
// 유효성 검사
  public void onlyDigit(String num) {
    for (int i = 0; i < num.length(); i++) {
      if (!Character.isDigit(num.charAt(i))) {
        throw new IllegalArgumentException(Constant.NOT_ONLY_DIGIT.getMessage());
      }
    }
    int result = Integer.parseInt(num);
    isNumberInRange(result);
  }

  public void isNumberInRange(int num) {
    if (num > 45 || num < 1) {
      throw new IllegalArgumentException(Constant.NOT_RANGE_MESSAGE.getMessage());
    }
  }
}


