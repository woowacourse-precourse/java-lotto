package lotto;

import static lotto.LottoStore.PRICE;

public class LottoMoney {
    public static final int ZERO = 0;
    private final long money;

    public LottoMoney(String money) {
        this.money = validate(parseLong(money));
    }

    private long validate(long money) {
        if (money % PRICE == ZERO && money > ZERO) {
            return money;
        }
        throw new IllegalArgumentException("1000원 단위로 입력 가능합니다.");
    }

    private long parseLong(String money) {
        try {
            return Long.parseLong(money);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");
        }
    }


    public long lottosCount(int unit) {
        return money / unit;
    }

    public double getMoney() {
        return this.money;
    }
}
