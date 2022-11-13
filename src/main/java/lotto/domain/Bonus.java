package lotto.domain;

public class Bonus {
    private static final String INVALID_NUMBER_RANGE_MESSAGE = "[ERROR] 로또는 1부터 45까지의 숫자를 입력해야 합니다. 문제가 생긴 값 = ";
    private int number;

    public Bonus(int number) {
        validateNumberRange(number);
        this.number = number;
    }

    private void validateNumberRange(int number) {
        if (number >= 1 && number <= 45) {
            return;
        }
        System.out.println(INVALID_NUMBER_RANGE_MESSAGE + number);
        throw new IllegalArgumentException(INVALID_NUMBER_RANGE_MESSAGE + number);
    }

    public int getNumber() {
        return number;
    }
}
