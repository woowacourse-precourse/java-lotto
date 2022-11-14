package lotto.domain;

public class Bonus {
    private static final int LOTTO_START_RANGE = 1;
    private static final int LOTTO_END_RANGE = 45;
    private static final String INVALID_NUMBER_RANGE_MESSAGE = "[ERROR] 로또는 " + LOTTO_START_RANGE + "부터 " + LOTTO_END_RANGE + "까지의 숫자를 입력해야 합니다. 문제가 생긴 값 = ";
    private final int number;

    public Bonus(int number) {
        validateNumberRange(number);
        this.number = number;
    }

    private void validateNumberRange(int number) {
        if (number >= LOTTO_START_RANGE && number <= LOTTO_END_RANGE) {
            return;
        }
        System.out.println(INVALID_NUMBER_RANGE_MESSAGE + number);
        throw new IllegalArgumentException(INVALID_NUMBER_RANGE_MESSAGE + number);
    }

    public int getNumber() {
        return number;
    }
}
