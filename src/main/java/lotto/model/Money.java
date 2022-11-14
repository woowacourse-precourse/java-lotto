package lotto.model;

public class Money {
    private static final int MIN_BUY_UNIT = 1_000;
    private static final String ERROR_NOT_INT = "[ERROR] 숫자만 입력 가능합니다.";
    private static final String ERROR_UNIT = String.format("[ERROR] 최소 구매 단위는 %s원 입니다.", MIN_BUY_UNIT);

    private int money;

    public Money(String money) {
        int tmpMoney = convertInt(money);
        validate(tmpMoney);
        this.money = tmpMoney;
    }


    private int convertInt(String money) {
        try {
            return Integer.parseInt(money);
        } catch (NumberFormatException e) {
            System.out.println(ERROR_NOT_INT);
            throw new IllegalArgumentException(ERROR_NOT_INT);
        }
    }

    private void validate(int money) {
        try {
            if (money % MIN_BUY_UNIT != 0) {
                throw new IllegalArgumentException(ERROR_UNIT);
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public int getMoney() {
        return this.money;
    }
}
