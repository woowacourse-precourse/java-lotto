package lotto.domain;

public class LottoNumberValidUtils {

    public static final String ERROR_NOT_VALID_NUMBER_RANGE = "[ERROR] 로또 번호는 1~45 사이의 숫자 이어야 합니다.";
    public static final int MINIMUM_LOTTO_NUMBER = 1;
    public static final int MAXIMUM_LOTTO_NUMBER = 45;

    public static void validateRange(int number) {
        if (isOutRange(number)) {
            throw new IllegalArgumentException(ERROR_NOT_VALID_NUMBER_RANGE);
        }
    }

    private static boolean isOutRange(int number) {
        return (number < MINIMUM_LOTTO_NUMBER) || (number > MAXIMUM_LOTTO_NUMBER);
    }
}
