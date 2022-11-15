package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import lotto.Data.UserMoney;
import lotto.handler.InputMoneyHandler;
import lotto.view.Output;

public class InputMoney {
    public final int LOTTO_PRICE = 1000;
    public static int lottoPapers;
    InputMoneyHandler inputMoneyHandler = new InputMoneyHandler();
    Output output = new Output();

    public UserMoney inputMoney() {
        output.inputMoneyOrder();
        String inputMoney = Console.readLine();
        output.lineSpace();
        inputMoneyHandler.checkException(inputMoney);
        UserMoney userMoney = new UserMoney(Integer.parseInt(inputMoney));

        return userMoney;
    }

    public void calculateLottoPapers(UserMoney inputMoney) {
        lottoPapers = inputMoney.getMoney() / LOTTO_PRICE;
        output.purchaseLottoOrder(lottoPapers);
    }
}