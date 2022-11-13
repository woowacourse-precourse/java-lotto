package lotto.io;

public class ConsoleOutput implements Output {
    private static final String PURCHASE_PROMPT = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBER_PROMPT = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_PROMPT = "보너스 번호를 입력해 주세요.";

    @Override
    public void printPurchasePrompt() {
        System.out.println(PURCHASE_PROMPT);
    }

    @Override
    public void printWinningNumberPrompt() {
        System.out.println(WINNING_NUMBER_PROMPT);
    }

    @Override
    public void printBonusNumberPrompt() {
        System.out.println(BONUS_NUMBER_PROMPT);
    }
}
