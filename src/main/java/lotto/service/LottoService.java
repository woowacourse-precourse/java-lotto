package lotto.service;

import lotto.entity.User;
import lotto.utils.Parser;
import lotto.utils.Validation;
import lotto.view.UserRequest;


public class LottoService {
    User user = new User();

    public void getPurchaseAmount() {
        String input = UserRequest.userInput();
        if (Validation.validatePurchaseAmount(input)) {
            user.setPurchaseAmount(Parser.convertStringToInt(input));
        }
    }


    
}
