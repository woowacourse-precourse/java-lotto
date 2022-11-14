package util;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    public static String purchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return Console.readLine();
    }
}

