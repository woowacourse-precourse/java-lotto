package view;

public class ExceptionView {

    private static final String UNIT_AMOUNT_ERROR = "[ERROR] 구입 금액은 1000원 단위입니다.";
    private static final String INPUT_PURCHASE_ERROR = "[ERROR] 구입 금액은 숫자만 입력 가능합니다.";
    private static final String LOTTO_NUMBERS_SIZE_ERROR = "[ERROR] 로또 번호는 6개만 선택되어야 합니다.";
    private static final String LOTTO_NUMBERS_BOUND_ERROR = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    private static final String LOTTO_NUMBERS_DUPLICATE_ERROR = "[ERROR] 로또 번호는 서로 중복되지 않아야 합니다.";
    private static final String EMPTY_INPUT_NUMBERS_ERROR = "[ERROR] 당첨 번호를 입력해야 합니다.";
    private static final String NON_DIGIT_INPUT_NUMBERS_ERROR = "[ERROR] 당첨 번호는 숫자만 입력 가능합니다.";
    private static final String WINNING_NUMBERS_SIZE_ERROR = "[ERROR] 당첨 번호는 6개만 선택되어야 합니다.";
    private static final String WINNING_NUMBERS_BOUND_ERROR = "[ERROR] 당첨 번호는 1부터 45 사이의 숫자여야 합니다.";
    private static final String WINNING_NUMBERS_DUPLICATE_ERROR = "[ERROR] 당첨 번호는 서로 중복되지 않아야 합니다.";

    public static void printErrorMessage(String errorType) {
        if (errorType == "UNIT_AMOUNT_ERROR") System.out.println(UNIT_AMOUNT_ERROR);
        if (errorType == "INPUT_PURCHASE_ERROR") System.out.println(INPUT_PURCHASE_ERROR);
        if (errorType == "LOTTO_NUMBERS_SIZE_ERROR") System.out.println(LOTTO_NUMBERS_SIZE_ERROR);
        if (errorType == "LOTTO_NUMBERS_BOUND_ERROR") System.out.println(LOTTO_NUMBERS_BOUND_ERROR);
        if (errorType == "LOTTO_NUMBERS_DUPLICATE_ERROR") System.out.println(LOTTO_NUMBERS_DUPLICATE_ERROR);
        if (errorType == "EMPTY_INPUT_NUMBERS_ERROR") System.out.println(EMPTY_INPUT_NUMBERS_ERROR);
        if (errorType == "NON_DIGIT_INPUT_NUMBERS_ERROR") System.out.println(NON_DIGIT_INPUT_NUMBERS_ERROR);
        if (errorType == "WINNING_NUMBERS_SIZE_ERROR") System.out.println(WINNING_NUMBERS_SIZE_ERROR);
        if (errorType == "WINNING_NUMBERS_SIZE_ERROR") System.out.println(WINNING_NUMBERS_BOUND_ERROR);
        if (errorType == "WINNING_NUMBERS_SIZE_ERROR") System.out.println(WINNING_NUMBERS_DUPLICATE_ERROR);
    }
}
