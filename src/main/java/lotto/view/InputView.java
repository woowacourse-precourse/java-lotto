package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.money.Money.createPurchaseMoney;

import lotto.money.Money;

public class InputView {

    public static Money inputPurchaseMoney() {
        String purchaseMoney = readLine();
        return createPurchaseMoney(purchaseMoney);
    }
}
