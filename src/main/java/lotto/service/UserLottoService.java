package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import lotto.Data.UserMoney;
import lotto.handler.UserInputMoneyHandler;
import lotto.view.OutputView;

public class UserLottoService {
    public final int LOTTO_PRICE = 1000;
    UserInputMoneyHandler userInputMoneyHandler = new UserInputMoneyHandler();
    OutputView outputView = new OutputView();

    public UserMoney InputMoney() {

        outputView.inputMoneyOrder();
        String inputMoney = Console.readLine();
        lineSkip();
        userInputMoneyHandler.checkException(inputMoney);
        UserMoney userMoney = new UserMoney(stringToInteger(inputMoney));

        return userMoney;
    }
    public int stringToInteger(String value) {
        int number = Integer.parseInt(value);

        return number;
    }
    public void lottoCount(UserMoney inputMoney) {
        int lottoCount = inputMoney.getMoney() / LOTTO_PRICE;
        outputView.purchaseLottoOrder(lottoCount);
    }
    public void lineSkip() {
        System.out.println();
    }
}