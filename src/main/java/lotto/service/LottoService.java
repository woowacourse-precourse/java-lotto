package lotto.service;

import lotto.util.Validator;

public class LottoService {
    public static Integer getTheNumberOfLotto(String userInputMoney) {
        Validator.checkUserInputMoney(userInputMoney);
        return Integer.parseInt(userInputMoney);
    }




}
