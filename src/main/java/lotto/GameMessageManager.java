package lotto;

public class GameMessageManager {
  public static void printInputBuyAmountMessage() {
    System.out.println(GameMessage.INPUT_BUY_AMOUNT_MESSAGE.getMessage());
  }

  public static void printBuyCount(int count) {
    System.out.println("\n" + count + GameMessage.BUY_COUNT_MESSAGE.getMessage());
  }

  private enum GameMessage {
    INPUT_BUY_AMOUNT_MESSAGE("구입금액을 입력해 주세요."),
    BUY_COUNT_MESSAGE("개를 구매했습니다.");

    String message;

    GameMessage(String message) {
      this.message = message;
    }

    public String getMessage() {
      return this.message;
    }
  }
}
