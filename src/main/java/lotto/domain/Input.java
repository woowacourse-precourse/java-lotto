package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    public static int purchaseAmount() {
        String amount = Console.readLine();
        return Integer.parseInt(amount);
    }
}
