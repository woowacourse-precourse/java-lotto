package lotto.inputview;

import camp.nextstep.edu.missionutils.Console;
import lotto.Exception.Exception;

public class Input {
    public static String inputMoney() {
        String money;
        System.out.println("구입금액을 입력해 주세요.");
        money = Console.readLine();
        isValid(money);
        return money;
    }

    public static void isValid(String input) {
        Exception.isNum(input);
        Exception.isThousands(input);
    }
}
