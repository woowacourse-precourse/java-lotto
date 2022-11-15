package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class PurchaseView {
    public void requestPurchaseAmount() {
        System.out.println(GuideMessage.PURCHASE_AMOUNT_REQUEST);
    }

    public String getPurchaseAmount() {
        return Console.readLine();
    }
}
