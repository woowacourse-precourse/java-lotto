package lotto;

import lotto.ENUMS.ErrorMessages;
import lotto.ENUMS.Rank;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class User {
    int purchaseAmount;
    String earningsRate;
    Map<Rank, Integer> ranks = new TreeMap<>(Collections.reverseOrder());

    User(String input) {
        earningsRate = "0";
        validatePurchaseAmount(input);
        this.purchaseAmount = Integer.parseInt(input);
        for (Rank rank : Rank.values()) {
            ranks.put(rank, 0);
        }
    }

    public void validatePurchaseAmount(String input) {
        if (!input.matches("[+-]?\\d*(\\.\\d+)?")) {
            throw new IllegalArgumentException(ErrorMessages.ERROR_SIGN.getErrorMessage()
                    + " " + ErrorMessages.IS_NOT_NUMBER.getErrorMessage());
        }
        purchaseAmount = Integer.parseInt(input);
        if (purchaseAmount % LotteryDrawMachine.ea != 0) {
            throw new IllegalArgumentException(ErrorMessages.ERROR_SIGN.getErrorMessage()
                    + " " + ErrorMessages.DIVIDE_ERROR.getErrorMessage());
        }
    }

    public void settleEarningsRate() {
        double sum = 0.0;
        for (Rank rank : ranks.keySet()) {
            double winning = (double) rank.getWinnings();
            sum += ranks.get(rank) * winning;
        }
        earningsRate = String.format("%.1f", (sum / purchaseAmount) * 100);
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
}
