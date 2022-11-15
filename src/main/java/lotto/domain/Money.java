package lotto.domain;

import java.util.Objects;

public class Money {

    private int money;

    private Money(int money) {
        this.money = money;
    }

    public static Money of(int money) {
        return new Money(money);
    }

    public int exchangeLotto() {
        validateLottoUnit(money);
        return money / LottoConstant.LOTTO_PRICE;
    }

    private void validateLottoUnit(int money) {
        if (money % LottoConstant.LOTTO_PRICE != 0 || money <= 0) {
            throw new IllegalArgumentException(String.format("구입 금액은 %d원 단위로 입력해주세요", LottoConstant.LOTTO_PRICE));
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Money money1 = (Money) o;
        return money == money1.money;
    }

    @Override
    public int hashCode() {
        return Objects.hash(money);
    }

    public double divide(Money other) {
        return (double) money / other.money;
    }
}
