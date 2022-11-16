package lotto.domain;

import lotto.constant.LottoRule;
import lotto.exception.IllegalMoneyInputException;

public class MoneyValidator implements CanValidate<Integer> {
    @Override
    public void validate(Integer money) throws IllegalArgumentException {
        if (money % LottoRule.COST.getValue() != 0 || money < LottoRule.COST.getValue()) {
            throw new IllegalMoneyInputException();
        }
    }
}
