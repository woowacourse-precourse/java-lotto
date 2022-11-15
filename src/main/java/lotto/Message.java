package lotto;

public class Message {
    private static final String INPUT_MONEY = "구입금액을 입력해 주세요.";
    private static final String INPUT_WIN_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    private static final String LOTTO_RESULT = "당첨 통계";
    private static final String LINE = "---";
    private static final String YIELD_MESSAGE_START = "총 수익률은";
    private static final String YIELD_MESSAGE_END = "%입니다.";

    public Message() {
    }

    public static void printMoneyMessage() {
        System.out.println(INPUT_MONEY);
    }

    public static void printWinNumber() {
        System.out.println(INPUT_WIN_NUMBER);
    }

    public static void printBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER);
    }

    public static void printLottoResult() {
        System.out.println(LOTTO_RESULT);
    }

    public static void printLine() {
        System.out.println(LINE);
    }

    public static void printYield(double yield) {
        System.out.println(YIELD_MESSAGE_START + " " + yield + YIELD_MESSAGE_END);
    }
}
