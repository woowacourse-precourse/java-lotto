package lotto.domain;

public class LottoNumber {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    private final int number;

    public LottoNumber(int number) {
        validateBoundary(number);
        this.number = number;
    }

    private void validateBoundary(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 로또 번호의 허용 범위를 벗어난 숫자입니다.");
        }
    }
}
