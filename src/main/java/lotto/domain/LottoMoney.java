package lotto.domain;

public class LottoMoney {
    private final int money;

    public LottoMoney(int money) {
        validateMinimumAmount(money);
        validateUnit(money);
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    private void validateMinimumAmount(int money) {
        if (money / 1000 < 1) {
            throw new IllegalArgumentException("로또 구매 금액은 최소 1,000원 이상이어야 합니다.");
        }
    }

    private void validateUnit(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("로또 구매 금액은 1,000원 단위어야 합니다.");
        }
    }
}
