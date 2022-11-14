package lotto.view;

public class OutputView {
    public final static String INPUT_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";

    private void printlnMessage(String message) {

        System.out.println(message);
    }

    private void printMessage(String message) {

        System.out.print(message);
    }

    public void printPurchasePrice() {

        printlnMessage(INPUT_PURCHASE_AMOUNT_MESSAGE);
    }
}
