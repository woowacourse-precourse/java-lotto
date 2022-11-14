package lotto.domain;

import lotto.validation.UserLottoValidation;

public class UserLotto {
    private static final int LOTTO_BASE_PRICE = 1000;
    private final int userMoney;

    public UserLotto(int userMoney) {
        UserLottoValidation.canBuyLotto(userMoney);
        this.userMoney = userMoney;
    }

    public int countOfPurchasedLotto() {
        return userMoney / LOTTO_BASE_PRICE;
    }
}
