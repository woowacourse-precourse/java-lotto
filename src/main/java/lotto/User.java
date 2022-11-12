package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class User {
    String money_str;

    User() {
        System.out.println("구입금액을 입력해 주세요.");
        money_str = Console.readLine();
        checkThatPurchaseMoneyIsRightInput(money_str);
    }

    public void checkThatPurchaseMoneyIsRightInput(String purchaseMoney) {
        int money = Exception.isInteger(purchaseMoney);

        if (Exception.isNotMultipleOfThousand(money)) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원으로 나누어 떨어져야 합니다.");
        }
        if (Exception.isNotPositive(money)) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 양수여야 합니다.");
        }

    }


//    public void purchaseLotto() {
//        check
//    }


}
