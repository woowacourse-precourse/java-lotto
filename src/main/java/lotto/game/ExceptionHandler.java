package lotto.game;

public class ExceptionHandler {
    private static final String ERROR = "[ERROR] ";
    public static final String DIVISIBLE_1000_ONLY_MESSAGE = "1000으로 나눠 떨어지는 금액만 입력해주세요.";
    public static final String NUMBER_ONLY_MESSAGE = "1000으로 나눠 떨어지는 금액만 입력해주세요.";
    public static final String BONUS_NUMBER_DUPLICATE_MESSAGE = "숫자만 입력해주세요.";
    public static final String ILLEGAL_LOTTO_NUMBER_MESSAGE = "올바른 로또 번호가 아닙니다.";

    public static void throwException(String message) {
        System.out.println(ERROR + message);
        throw new IllegalArgumentException(ERROR + message);
    }
}
