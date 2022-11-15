package error;

public class Error {
    private static final String ERROR = "[ERROR]";
    private static final String BLANK = " ";
    public static final String INADEQUATE_LOTTO_NUMBER = "로또 번호는 6개입니다.";
    public static final String NUMBER_OUT_OF_BOUNDS = "로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    public static final String LOTTO_NUMBER_REPETITION = "유저의 로또 번호가 중복입니다.";
    public static final String INADEQUATE_MONEY_UNIT = "금액은 1,000원 단위여야 합니다.";
    public static final String INADEQUATE_INPUT_MONEY = "입력한 금액이 올바르지 않습니다.";

    public static void message(String errorMessage) {
        throw new IllegalArgumentException(ERROR + BLANK + errorMessage);
    }
}