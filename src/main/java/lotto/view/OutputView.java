package lotto.view;

public class OutputView {

    public static final String INPUT_PURCHASE_PRICE_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String INPUT_ANSWER_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";

    public static void printInputPurchasePrice() {
        System.out.println(INPUT_PURCHASE_PRICE_MESSAGE);
    }

    public static void printInputAnswerNumber() {
        System.out.println(INPUT_ANSWER_NUMBERS_MESSAGE);
    }
}
