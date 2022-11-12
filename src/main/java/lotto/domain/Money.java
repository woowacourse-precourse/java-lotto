package lotto.domain;

public class Money {
    public static final int MONEY_DIVIDE_UNIT = 1000;
    private final int money;
    public Money(String input) {
        this.money = validate(input);
    }

    public int processInput(String input) {
        try{
            return Integer.parseInt(input);
        }catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구입 금액에는 숫자만 입력해야 합니다.");
        }
    }

    public int validate(String input) {
        int money = processInput(input);
        if (money < MONEY_DIVIDE_UNIT) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원보다 커야합니다.");
        }
        if (money % MONEY_DIVIDE_UNIT != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위만 입력해야 합니다.");
        }
        return money;
    }

    public int getMoney() {
        return money;
    }

    public int getTicketCount() {
        return money / MONEY_DIVIDE_UNIT;
    }
}
