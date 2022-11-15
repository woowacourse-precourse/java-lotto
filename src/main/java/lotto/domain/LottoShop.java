package lotto.domain;

import lotto.ui.ERROR;

public class LottoShop {

    private final int LOTTO_PRICE = 1000;

    private void validate(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException(ERROR.IS_NOT_THOUSAND_UNIT.getMessage());
        }
    }
}
