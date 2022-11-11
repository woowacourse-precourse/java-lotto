package lotto;

public class ShowErrorMessage {

    private static final String ERROR_MESSAGE = "[ERROR] ";
    private static final String OUT_RANGE_LOTTO_NUMBER_MESSAGE = "로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    private static final String NOT_DIVIDE_MESSAGE = "금액은 1,000으로 나누어 떨어져야 합니다.";

    public static void showOutRangeLottoNumber() {
        System.out.println(ERROR_MESSAGE + OUT_RANGE_LOTTO_NUMBER_MESSAGE);
    }

    public static void showNotDivide() {
        System.out.println(ERROR_MESSAGE + NOT_DIVIDE_MESSAGE);
    }
}
