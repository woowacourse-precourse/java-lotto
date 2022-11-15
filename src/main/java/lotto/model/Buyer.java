package lotto.model;

import static lotto.view.SystemMessage.ERROR_MESSAGE;
import static lotto.view.SystemMessage.LESS_THAN_THOUSAND_ERROR_MESSAGE;
import static lotto.view.SystemMessage.MULTIPLE_THOUSAND_ERROR_MESSAGE;

public class Buyer {

    private final Integer money;
    private final Integer NumOfLotto;

    public Buyer(Integer money) {
        validateThousand(money);
        this.money = money;
        this.NumOfLotto = getNumberOfLotto(money);
    }

    public Integer getMoney() {
        return money;
    }

    public Integer getNumOfLotto() {
        return NumOfLotto;
    }

    private static void validateThousand(Integer money) {
        validateLessThanThousand(money);
        validateMultipleThousand(money);

    }

    private static void validateLessThanThousand(Integer money) {
        if (money < 1000) {
            throw new IllegalArgumentException(ERROR_MESSAGE + LESS_THAN_THOUSAND_ERROR_MESSAGE);
        }
    }

    private static void validateMultipleThousand(Integer money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE + MULTIPLE_THOUSAND_ERROR_MESSAGE);
        }
    }

    private int getNumberOfLotto(int money) {
        return money / 1000;
    }

}
