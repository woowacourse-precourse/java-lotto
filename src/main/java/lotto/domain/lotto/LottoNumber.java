package lotto.domain.lotto;

public class LottoNumber {
    public static final String ERROR_NUMBER_LESS_THAN_MAX_NUMBER = "[ERROR] 로또 번호는 45보다 큰 숫자를 입력 할 수 없습니다";
    public static final String ERROR_NUMBER_GREATER_THAN_MIN_NUMBER = "[ERROR] 로또 번호는 1보다 작은 숫자를 입력 할 수 없습니다";
    private static final Integer MAX_SIZE = 45;
    private static final Integer MIN_SIZE = 1;

    private final Integer number;

    public LottoNumber(final Integer input) {
        validateNumberLessThanMaxSize(input);
        validateNumberMoreThanMinSize(input);
        this.number = input;
    }

    private void validateNumberMoreThanMinSize(Integer input) {
        if (input < MIN_SIZE) {
            throw new IllegalArgumentException(ERROR_NUMBER_GREATER_THAN_MIN_NUMBER);
        }
    }

    private void validateNumberLessThanMaxSize(Integer input) {
        if (input > MAX_SIZE) {
            throw new IllegalArgumentException(ERROR_NUMBER_LESS_THAN_MAX_NUMBER);
        }
    }


}
