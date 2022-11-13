package lotto.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import lotto.Constants.NUMBER;
import lotto.Ranking;

public class Buyer {
    private int totalPurchaseAmout = NUMBER.ZERO;
    private int lottoPurchasedCount = NUMBER.ZERO;
    private long totalWinningPrize = NUMBER.ZERO;
    private List<Lotto> lottoPurchased;
    private HashMap<String, Integer> winningSummary;


    public Buyer() {
        this.totalPurchaseAmout = 0;
        this.lottoPurchased = new ArrayList<Lotto>();
        this.winningSummary = new HashMap<String, Integer>() {
            {
                put(Ranking.FIRST.getLabel(), NUMBER.ZERO);
                put(Ranking.SECOND.getLabel(), NUMBER.ZERO);
                put(Ranking.THIRD.getLabel(), NUMBER.ZERO);
                put(Ranking.FOURTH.getLabel(), NUMBER.ZERO);
                put(Ranking.FIFTH.getLabel(), NUMBER.ZERO);
                put(Ranking.LOSE.getLabel(), NUMBER.ZERO);
            }
        };
    }

    public HashMap<String, Integer> getWinningSummary() {
        return this.winningSummary;
    }

    public static void setWinningSummary(Buyer buyer, String Ranking) {
        int prevCount = buyer.winningSummary.get(Ranking).intValue();
        buyer.winningSummary.put(Ranking, prevCount + NUMBER.ONE);
    }

    public void setTotalPurchaseAmout(int totalPurchaseAmout) {
        this.totalPurchaseAmout = totalPurchaseAmout;
    }

    public void setLottoPurchased(Lotto lotto) {
        this.lottoPurchased.add(lotto);
        this.lottoPurchasedCount = this.lottoPurchased.size();
    }

    public long getTotalWinningPrize() {
        return this.totalWinningPrize;
    }

    public void setTotalWinningPrize(long totalWinningPrize) {

        this.totalWinningPrize += totalWinningPrize;
    }

    public int getTotalPurchaseAmout() {
        return this.totalPurchaseAmout;
    }

    public List<Lotto> getLottoPurchased() {
        return this.lottoPurchased;
    }

    public void setLottoPurchasedCount(int lottoPurchasedCount) {
        this.lottoPurchasedCount = lottoPurchasedCount;
    }

    public int getLottoPurchasedCount() {
        return this.lottoPurchasedCount;
    }

}
