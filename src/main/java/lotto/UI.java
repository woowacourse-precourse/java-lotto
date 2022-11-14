package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class UI {

    public String inputPurchase() {
        System.out.println(Notice.INPUT_PURCHASE.message());
        return readLine();
    }

}
