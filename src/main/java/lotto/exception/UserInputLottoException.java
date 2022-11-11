package lotto.exception;

import java.util.List;

public class UserInputLottoException {

    private final static int PERMITTED_LOTTO_LENGTH = 6;
    private final static int PERMITTED_BONUS_LENGTH = 1;

    public void validateLotto(String numbers, String bonusNumber) {
        validateLottoNumberLength(numbers);
    }

    public void validateLottoNumberLength(String inputNumbers) {
        if (inputNumbers.replace(",", "").length() != PERMITTED_LOTTO_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

}
