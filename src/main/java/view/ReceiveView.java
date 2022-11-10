package view;

import camp.nextstep.edu.missionutils.Console;
import model.Purchase;

public class ReceiveView {

    public static int purchaseLotto() {
        String money = Console.readLine();
        Purchase.validate(money);
        return Integer.parseInt(money);
    }
}
