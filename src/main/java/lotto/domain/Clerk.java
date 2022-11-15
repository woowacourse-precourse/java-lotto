package lotto.domain;

import lotto.constants.LottoConstants;
import lotto.constants.InputExceptionConstants;

public class Clerk {

    public int giveLottoQuantity(String input) {
        int money;
        int lottoQuantity;

        validateBlank(input);
        money = validateNumeric(input);
        validateZero(money);
        validateRest(money);

        lottoQuantity = money / LottoConstants.LOTTO_PRICE.getValue();

        return lottoQuantity;
    }

    private void validateZero(int money) {
        if (money == 0) {
            throw new IllegalArgumentException(InputExceptionConstants.INPUT_ZERO.getValue());
        }
    }

    private void validateRest(int money) {
        money = money % LottoConstants.LOTTO_PRICE.getValue();
        if (money != 0) {
            throw new IllegalArgumentException(InputExceptionConstants.INPUT_REST_EXIST.getValue());
        }
    }

    private int validateNumeric(String input) {
        int money;
        try {
            money = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(InputExceptionConstants.INPUT_NONE_NUMERIC.getValue());
        }
        return money;
    }

    private void validateBlank(String input) {
        if (input.length() == 0) {
            throw new IllegalArgumentException(InputExceptionConstants.INPUT_BLANK.getValue());
        }
    }

}
