package lotto.model;

public class PurchaseAmount {
    private final int money;

    public PurchaseAmount(int money) {
        validateMoney(money);
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    private void validateMoney(int money) {
        if (money < 1000) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 이상이어야 합니다.");
        }
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위로 입력해야 합니다.");
        }
    }
}
