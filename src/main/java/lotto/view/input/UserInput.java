package lotto.view.input;

import camp.nextstep.edu.missionutils.Console;
import lotto.validation.Validator;

public class UserInput {

    public long getLottoCount(){
        long price = getPrice();
        return price / 1000;
    }

    private Long getPrice() {
        long price = getNumericPrice();
        Validator.validatePriceRange(price);
        Validator.validateUnit(price);
        return price;
    }

    private Long getNumericPrice() {
        String userInput = getUserInput();
        Validator.validateStringIsNumeric(userInput);
        return Long.parseLong(userInput);
    }

    private String getUserInput() {
        return Console.readLine();
    }
}
