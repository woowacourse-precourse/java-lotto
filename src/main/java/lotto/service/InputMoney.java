package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import lotto.Data.UserMoney;
import lotto.handler.UserInputMoney;
import lotto.view.Output;

public class InputMoney {
    public final int LOTTO_PRICE = 1000;
    UserInputMoney userInputMoney = new UserInputMoney();
    Output output = new Output();

    public UserMoney InputMoney() {

        output.inputMoneyOrder();
        String inputMoney = Console.readLine();
        lineSkip();
        userInputMoney.checkException(inputMoney);
        UserMoney userMoney = new UserMoney(stringToInteger(inputMoney));

        return userMoney;
    }
    public int stringToInteger(String value) {
        int number = Integer.parseInt(value);

        return number;
    }
    public void lottoCount(UserMoney inputMoney) {
        int lottoCount = inputMoney.getMoney() / LOTTO_PRICE;
        output.purchaseLottoOrder(lottoCount);
    }
    public void lineSkip() {
        System.out.println();
    }
}