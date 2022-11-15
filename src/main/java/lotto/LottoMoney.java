package lotto;

import java.util.Objects;

public class LottoMoney {

    private static final int LOTTERY_PRICE_PER_ONE = 1_000;
    private final int money;

    private LottoMoney(int money) {
        validate(money);
        this.money = money;
    }

    public static LottoMoney from(int money) {
        return new LottoMoney(money);
    }

    private void validate(int money) {
        if (money < LOTTERY_PRICE_PER_ONE)
            throw new IllegalArgumentException("[ERROR]");
        if (money % LOTTERY_PRICE_PER_ONE != 0)
            throw new IllegalArgumentException("[ERROR]");
    }

    public int lotteryCount() {
        return money / LOTTERY_PRICE_PER_ONE;
    }

    public int getMoney() {
        return money;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof LottoMoney))
            return false;
        LottoMoney that = (LottoMoney) o;
        return getMoney() == that.getMoney();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMoney());
    }
}
