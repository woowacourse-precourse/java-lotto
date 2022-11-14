package lotto;

import lotto.ENUMS.Rank;

import java.util.HashMap;
import java.util.Map;

public class User {
    int purchaseAmount;
    int earningsRate;
    Map<Rank, Integer> ranks = new HashMap<>();

    User(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
        for (Rank rank : Rank.values()) {
            ranks.put(rank, 0);
        }
    }

    public void validatePurchaseAmount() {

    }

    public void recordRanks() {

    }

    public void settleEarningsRate() {

    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    public int getEarningsRate() {
        return earningsRate;
    }

    public Map<Rank, Integer> getRanks() {
        return ranks;
    }

    public void setRanks(Map<Rank, Integer> ranks) {
        this.ranks = ranks;
    }
}
