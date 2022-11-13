package lotto.view;

public class GuidanceMessage {
    public static final String INSERT_MONEY = "구입금액을 입력해 주세요.";
    public static final String INSERT_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    public static final String INSERT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public static void informToInsertMoney() {
        System.out.println(INSERT_MONEY);
    }

    public static void informToInsertWinningNumbers() {
        System.out.println(INSERT_WINNING_NUMBERS);
    }

    public static void informToInsertBonusNumber() {
        System.out.println(INSERT_BONUS_NUMBER);
    }
}
