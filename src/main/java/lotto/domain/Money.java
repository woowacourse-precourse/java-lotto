package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

import static lotto.domain.AdditionalFunction.StringToInt;
import static lotto.view.ErrorMessage.*;

public class Money {
    private final int money;

    public Money() {
        String inputMoney = Console.readLine();
        int verifyMoney = StringToInt(inputMoney);
        validateUnit(verifyMoney);
        validatePositiveNum(verifyMoney);
        this.money = verifyMoney;
    }

    public int getMoney(){
        return this.money;
    }

    private void validatePositiveNum(int money) {
        if (money < 1000) {
            throw new IllegalArgumentException(ERROR_MESSAGE+LESS_THAN_THOUSAND_ERROR_MESSAGE);
        }
    }

    private void validateUnit(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE+THOUSAND_UNIT_ERROR_MESSAGE);
        }
    }
}
