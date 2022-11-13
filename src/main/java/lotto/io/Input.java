package lotto.io;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Input {
    private final int MIN_UNIT = 1000;

    public int enterPurchaseAmt() {
        System.out.println("구입금액을 입력해 주세요.");
        String amount = readLine();

        System.out.printf("\n%d개를 구매했습니다.\n", Integer.parseInt(amount) / MIN_UNIT);
        return Integer.parseInt(amount);
    }
}
