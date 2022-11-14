package lotto.message;

public class ErrorMessage {

    private static String head = "[ERROR]";
    public static final String AMOUNT_ERROR_MESSAGE = head + "구매 금액은 1,000원 단위이여야 합니다.";

    public static final String DUPLICATED_MESSAGE = head + "로또 번호는 중복되지 않는 숫자여야 합니다.";
    public static final String WRONG_SIZE_MESSAGE = head + "로또 번호는 중복되지 않는 6개의 숫자여야 합니다.";
    public static final String WRONG_RANGE_NUM_MESSAGE = head + "로또 번호는 1부터 45 사이의 숫자여야 합니다.";

    public static final String BONUS_NUM_ERROR_MESSAGE = head + "보너스 번호는 1부터 45 사이의 숫자여야 합니다.";
}
