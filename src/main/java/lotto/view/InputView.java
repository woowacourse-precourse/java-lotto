package lotto.view;

public class InputView {
    private static final String PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String BOUNS_NUMBER = "보너스 번호를 입력해 주세요.";

    public void printLottoMoney() {
        System.out.println(PURCHASE_AMOUNT);
    }

    public void printWinningNumber() {
        System.out.println();
        System.out.println(WINNING_NUMBER);
    }

    public void printBonusNumber() {
        System.out.println();
        System.out.println(BOUNS_NUMBER);
    }
}
