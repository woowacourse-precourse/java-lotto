package lotto.model.domain;

import java.util.regex.Pattern;
import lotto.utils.Utils;

public class PayingMoney {

    private static final int LOTTO_PRICE = 1000;
    private static final int NOTHING = 0;
    private static final String MONEY_REGEX = "^[0-9]*$";
    private static final String MONEY_IS_ONLY_NUMBER = "로또 구입 금액은 숫자 이어야 합니다.";
    private static final String MONEY_IS_MORE_THAN_1000 = "로또 구입 금액은 최소 1000원 이상 이어야 합니다.";
    private static final String MONEY_IS_FACTOR_OF_1000 = "로또 구입 금액은 1000원으로 나누어 떨어져야 합니다.";

    private final int money;

    public PayingMoney(String money) {
        this.money = validateMoney(money);
    }

    private int validateMoney(String money) {
        money = Utils.deleteAllString(money);
        if (!Pattern.matches(MONEY_REGEX, money)) {
            throw new IllegalArgumentException(MONEY_IS_ONLY_NUMBER);
        }
        return validateMoney(Integer.parseInt(money));
    }

    private int validateMoney(int money) {
        if (isLackMoney(money)) {
            throw new IllegalArgumentException(MONEY_IS_MORE_THAN_1000);
        }
        if (isMoneyNotFactorOf1000(money)) {
            throw new IllegalArgumentException(MONEY_IS_FACTOR_OF_1000);
        }
        return money;
    }

    private boolean isMoneyNotFactorOf1000(int money) {
        return money % LOTTO_PRICE != NOTHING;
    }

    private boolean isLackMoney(int money) {
        return money < LOTTO_PRICE;
    }

    public int countNumberOfLottoBuying() {
        return money / LOTTO_PRICE;
    }

}
