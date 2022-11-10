package lotto.domain;

import java.util.ArrayList;

public class LottoPurchaseInformation {
    private static final int THOUSAND = 1000;
    private ValueValidation valueValidator = new ValueValidation();
    private ArrayList<Lotto> lottoTickets = new ArrayList<>();
    private int numberOfTickets;

    public LottoPurchaseInformation(int purchaseAmount){
        valueValidator.checkDividedByThousand(purchaseAmount);
        numberOfTickets = purchaseAmount/THOUSAND;
    }


}
