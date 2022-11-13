package lotto.view;

public class OutputView {
    private static final String ERROR_MESSAGE = "[ERROR] ";
    private static final String PURCHASE_LOTTO_AMOUNT = "개를 구매했습니다.";
    private static final String NOT_NUMBER_ERROR = "숫자가 아닙니다.";
    private static final String NOT_INSEPARABLE_ERROR = "구입 금액이 1000원 단위가 아닙니다.";

    public static void printException(Exception e) {
        System.out.println(e.getMessage());
    }
}
