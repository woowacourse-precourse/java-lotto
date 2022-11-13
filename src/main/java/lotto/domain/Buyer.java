package lotto.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Buyer {
    private int totalPurchaseAmout = 0;
    private int lottoPurchasedCount = 0;
    private long totalWinningPrize = 0;
    private List<Lotto> lottoPurchased;
    private HashMap<String, Integer> winningSummary;


    public Buyer() {
        this.totalPurchaseAmout = 0;
        this.lottoPurchased = new ArrayList<Lotto>();
        this.winningSummary = new HashMap<String, Integer>() {
            {
                put("1ST", 0);
                put("2ND", 0);
                put("3RD", 0);
                put("4TH", 0);
                put("5TH", 0);
                put("LOSE", 0);
            }
        };
    }

    public HashMap<String, Integer> getWinningSummary() {
        return this.winningSummary;
    }

    public static void setWinningSummary(Buyer buyer, String Ranking) {
        int prevCount = buyer.winningSummary.get(Ranking).intValue();
        buyer.winningSummary.put(Ranking, prevCount + 1);
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
