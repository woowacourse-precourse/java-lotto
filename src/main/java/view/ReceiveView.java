package view;

import camp.nextstep.edu.missionutils.Console;
import util.exception.Valid;

public class ReceiveView {

    public static int purchaseAmount() {
        String money = Console.readLine();
        Valid.purchaseMoney(money);
        return Integer.parseInt(money);
    }
}
