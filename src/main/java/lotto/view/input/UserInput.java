package lotto.view.input;

import camp.nextstep.edu.missionutils.Console;
import lotto.validation.Validator;

public class UserInput {

    public int getLottoCount(){
        int price = getPrice();
        return price / 1000;
    }

    private int getPrice() {
        int price = getNumericPrice();
        Validator.validatePriceRange(price);
        Validator.validateUnit(price);
        return price;
    }

    private int getNumericPrice() {
        String userInput = getUserInput();
        Validator.validateStringIsNumeric(userInput);
        return Integer.parseInt(userInput);
    }

    private String getUserInput() {
        return Console.readLine();
    }
}
