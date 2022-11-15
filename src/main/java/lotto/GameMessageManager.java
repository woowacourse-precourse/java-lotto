package lotto;

public class GameMessageManager {
  public static void printBlankLine() {
    System.out.println();
  }

  public static void printInputBuyAmountMessage() {
    System.out.println(GameMessage.INPUT_BUY_AMOUNT_MESSAGE.getMessage());
  }

  public static void printBuyCount(int count) {
    System.out.println(count + GameMessage.BUY_COUNT_MESSAGE.getMessage());
  }

  public static void printInputPrizeNumberMessage() {
    System.out.println(GameMessage.INPUT_PRIZE_NUMBER_MESSAGE.getMessage());
  }

  public static void printInputBonusNumberMessage() {
    System.out.println(GameMessage.INPUT_BONUS_NUMBER_MESSAGE.getMessage());
  }

  public static void printShowPrizeStatisticsMessage() {
    System.out.println(GameMessage.SHOW_PRIZE_STATISTICS_MESSAGE.getMessage());
  }

  public static void printShowReturnRateMessage(float returnRate) {
    System.out.println(
        GameMessage.SHOW_RETURN_RATE_1_MESSAGE.getMessage()
            + returnRate
            + GameMessage.SHOW_RETURN_RATE_2_MESSAGE.getMessage());
  }

  private enum GameMessage {
    INPUT_BUY_AMOUNT_MESSAGE("구입금액을 입력해 주세요."),
    BUY_COUNT_MESSAGE("개를 구매했습니다."),
    INPUT_PRIZE_NUMBER_MESSAGE("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER_MESSAGE("보너스 번호를 입력해 주세요."),
    SHOW_PRIZE_STATISTICS_MESSAGE("당첨 통계\n---"),
    SHOW_RETURN_RATE_1_MESSAGE("총 수익률은 "),
    SHOW_RETURN_RATE_2_MESSAGE("%입니다.");

    String message;

    GameMessage(String message) {
      this.message = message;
    }

    public String getMessage() {
      return this.message;
    }
  }
}
