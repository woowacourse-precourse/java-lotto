package lotto;

public class ShowErrorMessage {

    private static final String ERROR_MESSAGE = "[ERROR] ";
    private static final String OUT_RANGE_LOTTO_NUMBER_MESSAGE = "로또 번호는 1부터 45 사이의 숫자여야 합니다.";

    public static void showOutRangeLottoNumber() {
        System.out.println(ERROR_MESSAGE + OUT_RANGE_LOTTO_NUMBER_MESSAGE);
    }
}
