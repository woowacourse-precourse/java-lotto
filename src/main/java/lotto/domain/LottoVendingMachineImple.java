package lotto.domain;


import java.util.List;

import static lotto.domain.messages.ErrorMessages.EXPENSES_RANGE_ERROR_MESSAGE;

public class LottoVendingMachineImple implements LottoVendingMachine{

    private static final Integer MONEY_UNIT = 1000;
    @Override
    public List<Lotto> generateLottos(Integer money) {
        validate(money);
        return Lotto.generateByAmount(calculateTotalAmount(money));
    }

    private void validate(Integer money) {
        validateIsPositiveMultipleOf1000(money);
    }

    private void validateIsPositiveMultipleOf1000(Integer money) {
        if (money < MONEY_UNIT || money % MONEY_UNIT != 0) {
            throw new IllegalArgumentException(EXPENSES_RANGE_ERROR_MESSAGE);
        }

    }
    private Integer calculateTotalAmount(Integer money) {
        return money / MONEY_UNIT;
    }
}
