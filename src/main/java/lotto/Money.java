package lotto;

public class Money {

    public static final String BLANK = " ";
    private static final int BASE_AMOUNT = 1_000;

    private final int money;

    public Money(String money) {
        this.money = validateMoney(money);
    }

    private int validateMoney(String money) {
        String blank = validateBlank(money);
        int number = validateModifyInputMoneyType(blank);
        return validateDivideMoney(number);
    }

    private String validateBlank(String money) {
        if (money.contains(BLANK)) {
            throw new IllegalArgumentException("[ERROR] 공백이 포함되어 있습니다.");
        }
        return money;
    }

    private int validateModifyInputMoneyType(String money) {
        try {
            return Integer.parseInt(money);
        } catch (IllegalArgumentException exceptionMessage) {
            throw new IllegalArgumentException("[ERROR] 입력한 금액이 숫자가 아닙니다.");
        }
    }

    private int validateDivideMoney(int moneyCount) {
        if (moneyCount < BASE_AMOUNT) {
            throw new IllegalArgumentException("[ERROR] 입력한 금액이 1,000원 미만 입니다.");
        }
        return moneyCount / BASE_AMOUNT;
    }

    public int getMoney() {
        return money;
    }

}