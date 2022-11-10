package lotto.Message;

public class ErrorMessage {
    public static final String BASE_ERROR_MESSAGE = "[ERROR]";
    public static final String NUMBER_RANGE_ERROR_MESSAGE = BASE_ERROR_MESSAGE + "로또 번호는 1부터 45사이의 숫자여야 합니다.";
    public static final String MONEY_INPUT_ERROR_MESSAGE = BASE_ERROR_MESSAGE + "1000원 단위로 입력해야 합니다.";
    public static final String NON_NUMERIC_INPUT_ERROR_MESSAGE = BASE_ERROR_MESSAGE + "숫자를 입력해야 합니다.";

    public static void printNumberRangeErrorMessage() {
        System.out.println(NUMBER_RANGE_ERROR_MESSAGE);
    }

    public static void printMoneyInputErrorMessage() {
        System.out.println(MONEY_INPUT_ERROR_MESSAGE);
    }

    public static void printNonNumericInputErrorMessage() {
        System.out.println(NON_NUMERIC_INPUT_ERROR_MESSAGE);
    }


}
