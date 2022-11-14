package lotto.io;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.WinningNumber;

public final class Reader {

    private Reader() {

    }

    public static String readUserPurchaseAmount() {
        return Console.readLine();
    }

    public static String readWinningNumbers() {
        return Console.readLine();
    }
}
