package lotto;

import java.util.Arrays;

public class WinningNumber {

  public void splitNumber(String userNumber) {
    String[] number = userNumber.split(",");
    for (String num : number) {
      validateLine(num);
    }
  }

  public void validateLine(String num) {
    for (int i = 0; i < num.length(); i++) {
      if (!Character.isDigit(num.charAt(i))) {
        throw new IllegalArgumentException("[ERROR] 숫자가 아닙니다");
      }
    }
    int result = Integer.parseInt(num);

    if (result > 45 || result < 1) {
      throw new IllegalArgumentException("[ERROR] 범위 내의 숫자가 아닙니다.");
    }
  }

  public static void main(String[] args) {
    WinningNumber win = new WinningNumber();

    win.splitNumber("12a,3,45,23");
  }
}


