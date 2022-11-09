package view;

import camp.nextstep.edu.missionutils.Console;

public class ReceiveView {

    public static int purchaseAmount() {
        String money = Console.readLine();
        int purchaseMoney = Integer.parseInt(money);
        return purchaseMoney;
    }
}
