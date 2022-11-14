package lotto;

public class Money {
    private int money;

    public Money(int money) {
        validate(money);

        this.money = money;
    }

    private void validate(int money) {
        if (money % 1000 != 0 && money >= 1000) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위입니다.");
        }
    }

    public int getNumberToPublishLottos() {
        return this.money / 1000;
    }

    public String calculateYield(long proceeds) {
        return String.format("%.1f", (proceeds / (double) money) * 100.0);
    }
}
