package lotto.domain;

import java.util.ArrayList;
import java.util.HashMap;

public class Buyer {
    private static final long ZERO = 0;
    private static final double PERCENT = 100;

    private final ArrayList<Lotto> purchasedLotteries = new ArrayList<>();
    private final int purchaseAmount;
    private final HashMap<Rank,Integer> lottoResult = new HashMap<>();

    public Buyer(int purchaseAmount){
        this.purchaseAmount = purchaseAmount;
        initLottoResult();
    }

    private void initLottoResult(){
        lottoResult.put(Rank.FIRST,0);
        lottoResult.put(Rank.SECOND,0);
        lottoResult.put(Rank.THIRD,0);
        lottoResult.put(Rank.FOURTH,0);
        lottoResult.put(Rank.FIFTH,0);
        lottoResult.put(Rank.NO_RANK,0);
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

    public HashMap<Rank, Integer> getLottoResult() {
        return lottoResult;
    }

    public long getPrizeSum(){
        long sum = ZERO;
        for(Rank rank :lottoResult.keySet()){
            sum += rank.getPrize() * lottoResult.get(rank);
        }
        return sum;
    }

    public double getYield(){
        return (getPrizeSum() / (double)purchaseAmount) * PERCENT;
    }
}
