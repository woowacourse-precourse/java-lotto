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
        throw new IllegalArgumentException("[ERROR] 숫자가 아닙니다");
      }
    }
    int result = Integer.parseInt(num);
    if (result > 45 || result < 1) {
      throw new IllegalArgumentException("[ERROR] 1 ~ 45 내의 숫자가 아닙니다.");
    }
  }

  public static void main(String[] args){
    WinningNumber win = new WinningNumber();
    win.splitNumber("133,2,4");
  }
}


