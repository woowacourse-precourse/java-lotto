package lotto.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import lotto.Constants.NUMBER;
import lotto.Ranking;

public class Buyer {
    private int payment = NUMBER.ZERO;
    private int lottoPurchasedCount = NUMBER.ZERO;
    private long totalWinningPrize = NUMBER.ZERO;
    private List<Lotto> purchasedLotto;
    private HashMap<String, Integer> winningSummary;


    public Buyer() {
        this.payment = 0;
        this.purchasedLotto = new ArrayList<Lotto>();
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

    static void setWinningSummary(Buyer buyer, String Ranking) {
        int prevCount = buyer.winningSummary.get(Ranking).intValue();
        buyer.winningSummary.put(Ranking, prevCount + NUMBER.ONE);
    }

    public int getPayment() {
        return this.payment;
    }
    public void setPayment(int payment) {
        this.payment = payment;
    }

    public void setPurchasedLotto(Lotto lotto) {
        this.purchasedLotto.add(lotto);
        this.lottoPurchasedCount = this.purchasedLotto.size();
    }

    public long getTotalWinningPrize() {
        return this.totalWinningPrize;
    }

    public void setTotalWinningPrize(long totalWinningPrize) {
        this.totalWinningPrize += totalWinningPrize;
    }

    public List<Lotto> getPurchasedLotto() {
        return this.purchasedLotto;
    }

    public void setLottoPurchasedCount(int lottoPurchasedCount) {
        this.lottoPurchasedCount = lottoPurchasedCount;
    }

    public int getLottoPurchasedCount() {
        return this.lottoPurchasedCount;
    }

}
