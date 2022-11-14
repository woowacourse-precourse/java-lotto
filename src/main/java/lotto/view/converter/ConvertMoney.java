package lotto.view.converter;

import lotto.exception.ExceptionPhrase;
import lotto.view.validation.MoneyValidation;

public class ConvertMoney implements Converter<String, Integer>{

    private final MoneyValidation moneyValidation;

    public ConvertMoney() {
        moneyValidation = new MoneyValidation();
    }

    @Override
    public Integer toNumbers(String input) {
        moneyValidation.validateInputIsInteger(input);

        return Integer.parseInt(input);
    }
}
