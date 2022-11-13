package lotto.input;

import java.util.List;
import lotto.exception.LottoException;

public class InputValidator {
    private static final long LOTTO_PRICE = 1_000L;

    public void validationZeroAmount(long amount) {
        if (amount % LOTTO_PRICE != 0 && amount != 0) {
            throw new LottoException(this.getClass());
        }
    }

    public void validationAmount(long amount) {
        if (amount % 1000 != 0) {
            throw new LottoException(this.getClass());
        }
    }

    public void validationInputLength(String input) {
        if (input.length() == 0) {
            throw new LottoException(this.getClass());
        }
    }

    public void validationNumberInRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (!(1 <= number && number <= 45)) {
                throw new LottoException(this.getClass());
            }
        }
    }
}
