package lotto.view;


import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Amounts;

import static lotto.util.ValidUtil.validAmountUnit;
import static lotto.util.ValidUtil.validInputAmounts;

public class Input {

    public static Amounts inputPurchasingAmount() {
        System.out.println("구입 금액을 입력해 주세요");
        String input = validInputAmounts(Console.readLine());
        int amount = validAmountUnit(Integer.parseInt(input));
        return new Amounts(amount);
    }

}
