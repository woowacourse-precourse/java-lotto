package lotto.domain;

public class Money {
    private final String WARM = "[ERROR] ";
    private final String WARM_NOT_VALID_MONEY_UNIT = WARM + "1000원 단위로만 돈일 입력할 수 있습니다.";
    private final String WARM_EXCEED_MONEY_SPEND = WARM + "돈을 초과해서 사용할 수 없습니다.";
    private final int ZERO = 0;
    private final int LOTTO_PRICE = 1000;

    private int currentMoney;
    private int paidMoney;

    public Money(int money) {
        validateMoneyUnit(money);
        this.currentMoney = money;
        this.paidMoney = ZERO;
    }

    public int getCurrentMoney() {
        return currentMoney;
    }

    public int getPaidMoney() {
        return paidMoney;
    }

    public int getInitialMoney() {
        return currentMoney + paidMoney;
    }

    private void validateMoneyUnit(int money) {
        if (money % LOTTO_PRICE != ZERO) {
            System.out.println(WARM_NOT_VALID_MONEY_UNIT);
            throw new IllegalArgumentException(WARM_NOT_VALID_MONEY_UNIT);
        }
    }

    public boolean paid(int price, int count) {
        int money = price * count;
        if (this.currentMoney - money < ZERO) {
            System.out.println(WARM_EXCEED_MONEY_SPEND);
            throw new IllegalArgumentException(WARM_EXCEED_MONEY_SPEND);

        }
        this.currentMoney -= money;
        this.paidMoney += money;
        return true;
    }
}