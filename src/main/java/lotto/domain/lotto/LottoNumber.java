package lotto.domain.lotto;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {
    public static final String ERROR_NUMBER_LESS_THAN_MAX_NUMBER = "[ERROR] 로또 번호는 45보다 큰 숫자를 입력 할 수 없습니다";
    public static final String ERROR_NUMBER_GREATER_THAN_MIN_NUMBER = "[ERROR] 로또 번호는 1보다 작은 숫자를 입력 할 수 없습니다";
    public static final String ERROR_INPUT_IS_NUMBER = "[ERROR] 로또 번호는 숫자만 입력할 수 있습니다.";
    private static final Integer MAX_SIZE = 45;
    private static final Integer MIN_SIZE = 1;


    private final Integer number;

    public LottoNumber(final Integer input) {
        validateNumberLessThanMaxSize(input);
        validateNumberMoreThanMinSize(input);
        this.number = input;
    }

    public LottoNumber(final String input) {
        validateInputIsNumber(input);

        var number = Integer.parseInt(input);

        validateNumberLessThanMaxSize(number);
        validateNumberMoreThanMinSize(number);
        this.number = number;
    }

    private void validateInputIsNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException(ERROR_INPUT_IS_NUMBER);
        }

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


    public Integer number() {
        return this.number;
    }

    @Override
    public int compareTo(LottoNumber o) {
        return this.number.compareTo(o.number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoNumber that = (LottoNumber) o;
        return Objects.equals(number, that.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
