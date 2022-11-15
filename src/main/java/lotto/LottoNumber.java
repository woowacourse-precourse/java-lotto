package lotto;

public class LottoNumber {

    private static final int MIN_LOTTO_NUM = 1;
    private static final int MAX_LOTTO_NUM = 45;
    private final int number;

    private LottoNumber(int number) {
        validate(number);
        this.number = number;
    }

    private static void validate(int number) {
        if (number < MIN_LOTTO_NUM || number > MAX_LOTTO_NUM) {
            throw new IllegalArgumentException("[ERROR]");
        }

    }
}
