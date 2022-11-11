package lotto;

public class WinningNumber {
  // ','를 기준으로 split 시행
  public void splitNumber(String userNumber) {
    String[] number = userNumber.split(",");
    for (String num : number) {
      validateNumber(num);
    }
  }
// 유효성 검사
  public void validateNumber(String num) {
    for (int i = 0; i < num.length(); i++) {
      if (!Character.isDigit(num.charAt(i))) {
        throw new IllegalArgumentException(Constant.NOT_ONLY_DIGIT);
      }
    }
    int result = Integer.parseInt(num);
    if (result > 45 || result < 1) {
      throw new IllegalArgumentException(Constant.NOT_RANGE_MESSAGE);
    }
  }
}


