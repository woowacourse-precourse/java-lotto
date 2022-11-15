package lotto.domain;

import lotto.constant.LottoConstant;

public class Money {
    private final Long amount;

    private Money(Long money) {
        validateLottoMoney(money);
        this.amount = money;

    }

    public static Money of(Long money) {
        return new Money(money);
    }

    public Double calcYield(Long prizeMoney) {
        if (prizeMoney == 0) {
            return 0.0;
        }
        return prizeMoney / (double) this.amount * 100;
    }

    public int calcLottoQuantity() {
        return amount.intValue() / LottoConstant.AMOUNT_UNIT;
    }

    private void validateLottoMoney(Long money) {
        if (money % LottoConstant.AMOUNT_UNIT != 0) {
            throw new IllegalArgumentException("[ERROR] 입력금액은 1000원 단위여야 합니다.");
        }
    }
}