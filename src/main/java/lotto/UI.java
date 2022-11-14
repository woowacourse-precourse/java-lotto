package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class UI {

    public String inputPurchase() {
        System.out.println(Notice.INPUT_PURCHASE.message());
        return readLine();
    }

    public String inputWinningNumber() {
        System.out.println(Notice.INPUT_WINNING_NUMBER.message());
        return readLine();
    }

}
