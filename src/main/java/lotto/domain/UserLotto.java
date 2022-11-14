package lotto.domain;

import lotto.validation.UserLottoValidation;

public class UserLotto {
    private final int userMoney;

    public UserLotto(int userMoney) {
        UserLottoValidation.canBuyLotto(userMoney);
        this.userMoney = userMoney;
    }
}
