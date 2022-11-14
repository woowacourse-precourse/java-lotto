package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class LottoPurchaseUI {
    public String takePurchaseAmount(){
        System.out.println("구입금액을 입력해 주세요.");
        String purchaseAmountInput = readLine();
        return purchaseAmountInput;
    }
}
