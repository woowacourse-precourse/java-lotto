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

    private static int validateMoney(String money) {
        money = Utils.deleteAllString(money);
        if (!Pattern.matches(MONEY_REGEX, money)) {
            throw new IllegalArgumentException(MONEY_IS_ONLY_NUMBER);
        }
        int parsedMoney = Integer.parseInt(money);

        if (parsedMoney < LOTTO_PRICE) {
            throw new IllegalArgumentException(MONEY_IS_MORE_THAN_1000);
        }
        if (parsedMoney % LOTTO_PRICE != NOTHING) {
            throw new IllegalArgumentException(MONEY_IS_FACTOR_OF_1000);
        }
        return parsedMoney;
    }

    public Lottos createLottos() {
        int numOfLotto = money / LOTTO_PRICE;
        return new Lottos(numOfLotto);
    }

}
