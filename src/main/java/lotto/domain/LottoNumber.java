package lotto.domain;

public class LottoNumber {
    private final int MIN = 1;
    private final int MAX = 45;
    private final int number;

    private final String RANGE_ERROR = "번호는 1~45 까지만 허용됩니다.";

    public LottoNumber(int number) {
        validate(number);
        this.number = number;
    }

    private void validate(int number) {
        if (number < MIN || number > MAX) {
            throw new IllegalArgumentException(RANGE_ERROR);
        }
    }

    public int getNumber() {
        return number;
    }
}
