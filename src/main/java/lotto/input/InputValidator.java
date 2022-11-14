package lotto.input;

import java.util.List;
import lotto.exception.LottoException;

public class InputValidator {
    private static final int LOTTO_PRICE = 1_000;

    public void validationInputLength(String input) { // 입력한 값이 있는지 확인
        if (input.length() == 0) {
            throw new LottoException(this.getClass());
        }
    }

    public void validationZeroAmount(int amount) { // 금액이 0원인지 확인
        if (amount % LOTTO_PRICE != 0 && amount != 0) {
            throw new LottoException(this.getClass());
        }
    }

    public void validationAmount(int amount) { // 금액이 1000의 배수인지 확인
        if (amount % LOTTO_PRICE != 0) {
            throw new LottoException(this.getClass());
        }
    }

}
