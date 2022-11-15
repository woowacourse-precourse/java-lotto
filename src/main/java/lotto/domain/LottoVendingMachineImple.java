package lotto.domain;


import java.util.List;

import static lotto.domain.messages.ErrorMessages.EXPENSES_RANGE_ERROR_MESSAGE;

public class LottoVendingMachineImple implements LottoVendingMachine{
    @Override
    public List<Lotto> generateLottos(Integer money) {
        validate(money);
        return Lotto.generateByAmount(calculateTotalAmount(money));
    }

    private void validate(Integer money) {
        validateIsPositiveMultipleOf1000(money);
    }

    private void validateIsPositiveMultipleOf1000(Integer money) {
        if (money < 1000 || money % 1000 != 0) {
            throw new IllegalArgumentException(EXPENSES_RANGE_ERROR_MESSAGE);
        }

    }
    private Integer calculateTotalAmount(Integer money) {
        return money / 1000;
    }
}
