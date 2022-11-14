package lotto.domain;

import lotto.validation.UserLottoValidation;

import static lotto.constant.LottoConstant.LOTTO_BASE_PRICE;

public class UserLotto {
    private final int userMoney;

    public UserLotto(int userMoney) {
        UserLottoValidation.canBuyLotto(userMoney);
        this.userMoney = userMoney;
    }

    public int countOfPurchasedLotto() {
        return userMoney / LOTTO_BASE_PRICE;
    }
}
