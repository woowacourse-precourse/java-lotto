package lotto;

import lotto.ENUMS.ErrorMessages;
import lotto.ENUMS.Rank;

import java.util.HashMap;
import java.util.Map;

public class User {
    int purchaseAmount;
    String earningsRate;
    Map<Rank, Integer> ranks = new HashMap<>();

    User(int purchaseAmount) {
        validatePurchaseAmount(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
        for (Rank rank : Rank.values()) {
            ranks.put(rank, 0);
        }
    }

    public void validatePurchaseAmount(int purchaseAmount) {
        if(purchaseAmount % LotteryDrawMachine.ea != 0) {
            throw new IllegalArgumentException(ErrorMessages.ERROR_SIGN.getErrorMessage()
                    + " " + ErrorMessages.DIVIDE_ERROR.getErrorMessage());
        }
    }

    public void settleEarningsRate() {
        double sum = 0.0;
        for(Rank rank : ranks.keySet()) {
            double winning = (double)rank.getWinnings();
            sum += ranks.get(rank) * winning;
        }
        earningsRate = String.format("%.1f", sum / purchaseAmount);
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    public String getEarningsRate() {
        return earningsRate;
    }

    public Map<Rank, Integer> getRanks() {
        return ranks;
    }

    public void setRanks(Map<Rank, Integer> ranks) {
        this.ranks = ranks;
    }
}
