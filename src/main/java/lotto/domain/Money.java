package lotto.domain;

public class Money {
    private static final int LOTTO_PRICE = 1000;
    private static final String ERROR_NON_POSITIVE_INTEGER = "[ERROR] 올바른 금액을 입력해주세요.";
    private static final String ERROR_NON_LOTTO_MONEY = "[ERROR] 로또는 하나 당 1000원 입니다.";

    private final int money;

    public Money(String money){
        validateMoney(money);
        this.money = Integer.parseInt(money);
    }

    private void validateMoney(String money) {
        int purchaseMoney;

        try {
            purchaseMoney = Integer.parseInt(money);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_NON_POSITIVE_INTEGER);
        }

        if (purchaseMoney < 0) {
            throw new IllegalArgumentException(ERROR_NON_POSITIVE_INTEGER);
        }

        if (purchaseMoney % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ERROR_NON_LOTTO_MONEY);
        }
    }

    public int getMoney() {
        return money;
    }
}
