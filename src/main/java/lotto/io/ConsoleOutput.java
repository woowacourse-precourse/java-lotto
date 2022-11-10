package lotto.io;

public class ConsoleOutput implements Output {
    private static final String PURCHASE_PROMPT = "구입금액을 입력해 주세요.";

    @Override
    public void printPurchasePrompt() {
        System.out.println(PURCHASE_PROMPT);
    }
}
