package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

public class LottoPurchaser {
    private final int purchaseAmount;

    public LottoPurchaser() {
        purchaseAmount = purchase();
    }

    private int purchase(){
        System.out.println(Message.PURCHASE_AMOUNT_REQUEST);

        String purchaseAmount = Console.readLine();

        validate(purchaseAmount);

        return Integer.parseInt(purchaseAmount);
    }

    private void validate(String purchaseAmount){

    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }
}
