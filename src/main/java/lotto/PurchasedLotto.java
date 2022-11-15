package lotto;

import camp.nextstep.edu.missionutils.Console;

public class PurchasedLotto {
    private Integer cost;

    public PurchasedLotto(Integer purchaseCost) {
        validate(purchaseCost);
        this.cost = purchaseCost;
    }

    public void validate(Integer value) {
        if (value % 1000 != 0) throw new IllegalArgumentException("[ERROR] 구입 금액이 천원 단위여야 합니다.");
        if (value <= 0) throw new IllegalArgumentException("[ERROR] 구입 금액이 천원 이상이어야 합니다.");
    }
}
