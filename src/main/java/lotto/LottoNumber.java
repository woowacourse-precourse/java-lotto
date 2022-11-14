package lotto;

public class LottoNumber {

    public static int LOTTO_MAX_NUMBER = 45;
    public static int LOTTO_MIN_NUMBER = 1;

    private final int number;

    public LottoNumber(int number) {
        validateNumberRange(number);
        this.number = number;
    }

    public static void validateNumberRange(int number) {
        if (number < LOTTO_MIN_NUMBER || LOTTO_MAX_NUMBER < number) {
            throw new IllegalArgumentException(
                    InvalidInputMessage.ERR_DEFAULT
                            + InvalidInputMessage.ERR_NUMBER_RANGE
            );
        }
    }

    public int getNumber() {
        return number;
    }
}
