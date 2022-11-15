package lotto.domain;

import static lotto.domain.SystemMessage.ERROR_MESSAGE;
import static lotto.domain.SystemMessage.LESS_THAN_THOUSAND_ERROR_MESSAGE;
import static lotto.domain.SystemMessage.MULTIPLE_THOUSAND_ERROR_MESSAGE;

import java.util.List;

public class Buyer {
    private final Integer money;
    private final Integer NumOfLotto;

    public Buyer(Integer money, Integer NumOfLotto) {
        validateThousand(money);
        this.money = money;
        this.NumOfLotto = NumOfLotto;
    }
    public Integer getMoney(){
        return money;
    }
    public Integer getNumOfLotto(){
        return NumOfLotto;
    }

    private static void validateThousand(Integer money) {
        validateLessThanThousand(money);
        validateMultipleThousand(money);

    }
    private static void validateLessThanThousand(Integer money) {
        if(money < 1000)
            throw new IllegalArgumentException(ERROR_MESSAGE + LESS_THAN_THOUSAND_ERROR_MESSAGE);
    }
    private static void validateMultipleThousand(Integer money) {
        if(money % 1000 != 0)
            throw new IllegalArgumentException(ERROR_MESSAGE + MULTIPLE_THOUSAND_ERROR_MESSAGE);
    }

}
