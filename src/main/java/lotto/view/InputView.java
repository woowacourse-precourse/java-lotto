package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import lotto.Money;

public class InputView {

    public static Money inputMoney() {
        String money = readLine();
        return new Money(money);
    }
}
