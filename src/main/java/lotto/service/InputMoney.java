package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import lotto.Data.UserMoney;
import lotto.handler.InputMoneyHandler;
import lotto.view.Output;

public class InputMoney {
    public final int LOTTO_PRICE = 1000;
    public static int lottoCount;
    InputMoneyHandler inputMoneyHandler = new InputMoneyHandler();
    Output output = new Output();

    public UserMoney InputMoney() {
        output.inputMoneyOrder();
        String inputMoney = Console.readLine();
        output.lineSpace();
        inputMoneyHandler.checkException(inputMoney);
        UserMoney userMoney = new UserMoney(Integer.parseInt(inputMoney));

        return userMoney;
    }

    public void calculateLottoPapers(UserMoney inputMoney) {
        lottoCount = inputMoney.getMoney() / LOTTO_PRICE;
        output.purchaseLottoOrder(lottoCount);
    }
}