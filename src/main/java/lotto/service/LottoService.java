package lotto.service;

import lotto.utils.Parser;
import lotto.utils.Validation;
import lotto.view.UserRequest;


public class LottoService {

    public int getPurchaseAmount() {
        String input = UserRequest.userInput();
        Validation.validateMultipleOfThousand(input);
        return input;
    }

    
}
