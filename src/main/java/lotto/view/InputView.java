package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.Money.createPurchaseMoney;

import lotto.Money;

public class InputView {

    public static Money inputMoney() {
        String money = readLine();
        return createPurchaseMoney(money);
    }
}
