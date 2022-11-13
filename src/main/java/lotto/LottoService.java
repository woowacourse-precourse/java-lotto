package lotto;

import static lotto.LottoConstant.INPUT_IS_NOT_NUMBER_ERROR_MESSAGE;

public class LottoService {

    private LottoService() {
    }

    public static int amountInputToInteger(String input) {
        if (!input.chars().allMatch((Character::isDigit))) {
            throw new IllegalStateException(INPUT_IS_NOT_NUMBER_ERROR_MESSAGE);
        }
        return Integer.parseInt(input);
    }
}
