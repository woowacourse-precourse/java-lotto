package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    public static int purchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String purchaseAmount = Console.readLine();

        return Integer.valueOf(purchaseAmount);
    }
}
