package lotto;

import java.util.HashMap;
import java.util.Map;

public class User {
    int purchaseAmount;
    int earningsRate;
    Map<Integer, Integer> ranks = new HashMap<>();

    User(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public void validatePurchaseAmount() {

    }

    public void recordRanks() {

    }

    public void settleEarningsRate() {

    }
}
