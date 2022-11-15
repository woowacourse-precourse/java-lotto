package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MoneyToAmount {
    private final int amount;
    private final double totalPrice;

    public MoneyToAmount(String money) {
        isValid(money);
        this.amount = convertToAmount(money);
        this.totalPrice = Integer.parseInt(money);
    }

    public void isValid(String money) {
        isNum(money);
        isThousands(money);
    }

    public void isNum(String money) {
        for (char c : money.toCharArray()) {
            if (!(Character.isDigit(c))) {
                throw new IllegalArgumentException("[ERROR] 숫자만 입력할 수 있습니다.");
            }
        }
    }

    public BigDecimal profitRatio(int totalPrize) {
        return new BigDecimal(totalPrize / totalPrice).setScale(2, RoundingMode.HALF_UP);
    }

    public void isThousands(String input) {
        int money = convertToInt(input);
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 천원 단위로 입력할 수 있습니다.");
        }
    }

    public int convertToInt(String input) {
        return Integer.parseInt(input);
    }

    public int convertToAmount(String input) {
        int money = convertToInt(input);
        return money / 1000;
    }

    public int getAmount() {
        return amount;
    }
}
