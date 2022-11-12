package view;

import camp.nextstep.edu.missionutils.Console;
import util.Validation;

public class UserInput {

    // 구입 금액을 입력하는 기능
    public static int purchaseMoney() {
        String money = Console.readLine();
        Validation.validatePurchaseMoney(money);
        return Integer.parseInt(money);
    }

}
