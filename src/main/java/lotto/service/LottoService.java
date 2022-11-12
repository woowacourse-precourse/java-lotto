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
    public void getLottoCount(int amount) {
        user.setLottoAmount(Parser.countLotto(amount));
    }



    
}
