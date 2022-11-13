package lotto.game;

import camp.nextstep.edu.missionutils.Console;
import lotto.validator.LottoPurchaseValidator;
import lotto.validator.UserInputValidator;
import lotto.view.UserInputView;

public class LottoGame {

    public void start() {
        int inputMoney = receiveMoney();
    }

    private int receiveMoney() {
        UserInputView.printInputPurchasePrice();
        String inputMoney = Console.readLine();
        UserInputValidator.validateStringIsNumeric(inputMoney);
        int inputMoneyParseInt = Integer.parseInt(inputMoney);
        LottoPurchaseValidator.validatePurchaseUnit(inputMoneyParseInt);
        return inputMoneyParseInt;
    }
}
