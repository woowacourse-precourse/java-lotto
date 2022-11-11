package lotto.domain;

import java.util.ArrayList;

public class Buyer {
    private ArrayList<Lotto> purchasedLotteries = new ArrayList<>();
    private int purchaseAmount;
    private long winningAmount=0;
    private double yield=0;

    public Buyer(int purchaseAmount){
        this.purchaseAmount = purchaseAmount;
    }

    public void buyLotto(Lotto lotto){
        purchasedLotteries.add(lotto);
    }

    public ArrayList<Lotto> getPurchasedLotteries() {
        return purchasedLotteries;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    public void setPurchaseAmount(int purchaseAmount){
        this.purchaseAmount = purchaseAmount;
    }

    public long getWinningAmount() {
        return winningAmount;
    }

    public double getYield() {
        return yield;
    }
}
