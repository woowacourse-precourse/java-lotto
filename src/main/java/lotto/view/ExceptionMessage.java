package lotto.view;

public class ExceptionMessage {

    private static String exception;

    public static String getException() {
        return exception;
    }

    public static void inputNumberError() {
        exception = "숫자가 아닌 값이 입력되었습니다.";
    }

    public static void overlabNumberError() {
        exception = "중복된 번호가 당첨될 수 없습니다.";
    }

    public static void numberRangeError() {
        exception = "로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    }

    public static void paymentUnitError() {
        exception = "로또 금액 단위로 입력해야 합니다.";
    }

    public static void existBonusNumberError() {
        exception = "입력한 보너스 번호가 이미 당첨 번호에 존재합니다.";
    }

    public static void inputNumberSizeError() {
        exception = "로또 번호는 6개의 숫자여야 합니다.";
    }
}
