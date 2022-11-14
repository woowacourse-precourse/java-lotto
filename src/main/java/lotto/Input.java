package lotto;

import camp.nextstep.edu.missionutils.Console;

import static lotto.InputValidator.*;

public class Input {

    static public Integer enterPurchaseMoney() {
        System.out.println("구입 금액을 입력해주세요.");
        return validatePurchaseMoney(Console.readLine());
    }

    static public String enterSixNumber() {
        return null;
    }

    static public String enterBonusNumber() {
        return null;
    }

}
