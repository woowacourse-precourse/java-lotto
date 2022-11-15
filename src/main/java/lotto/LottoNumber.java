package lotto;

import java.util.Objects;

public class LottoNumber {

    public static int LOTTO_MAX_NUMBER = 45;
    public static int LOTTO_MIN_NUMBER = 1;

    private final int number;

    public LottoNumber(int number) {
        validateNumberRange(number);
        this.number = number;
    }

    private static void validateNumberRange(int number) {
        if (number < LOTTO_MIN_NUMBER || LOTTO_MAX_NUMBER < number) {
            throw new IllegalArgumentException(
                    InvalidInputMessage.ERR_DEFAULT
                            + InvalidInputMessage.ERR_NUMBER_RANGE
            );
        }
    }

    @Override
    public boolean equals(Object object){
        LottoNumber lottoNumber = (LottoNumber) object;
        return this.number == lottoNumber.number;
    }

    @Override
    public int hashCode(){
        return Objects.hash(number);
    }

    public int getNumber() {
        return number;
    }
}
