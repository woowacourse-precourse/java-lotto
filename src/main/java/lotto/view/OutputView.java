package lotto.view;

public class OutputView {
    public final static String INPUT_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    public final static String INPUT_WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    public final static String INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    private void printlnMessage(String message) {

        System.out.println(message);
    }

    private void printMessage(String message) {

        System.out.print(message);
    }

    public void printInputPurchaseAmount() {

        printlnMessage(INPUT_PURCHASE_AMOUNT_MESSAGE);
    }

    public void printInputWinningNumber() {

        printlnMessage(INPUT_WINNING_NUMBER_MESSAGE);
    }

    public void printInputBonusNumber() {
        printlnMessage(INPUT_BONUS_NUMBER_MESSAGE);
    }
}
