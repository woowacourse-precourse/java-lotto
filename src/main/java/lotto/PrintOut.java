package lotto;

public class PrintOut {
  public static void requestInputMessage() {
    System.out.println("구입금액을 입력해 주세요.");
  }

  public static void isNotDigitMessage() {
    System.out.println("[ERROR] 숫자만 입력할 수 있습니다.");
  }

  public static void isNotValuableMoneyMessage() {
    System.out.println("[ERROR] 1000원 단위로 입력해 주세요.");
  }
}
