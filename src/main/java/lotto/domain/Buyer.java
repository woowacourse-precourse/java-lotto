package lotto.domain;

import java.util.ArrayList;
import java.util.HashMap;

public class Buyer {
    private static long ZERO = 0;
    private static int roundIntConstatnt = 10;
    private static double roundDoubleConstatnt = 10.0;

    private ArrayList<Lotto> purchasedLotteries = new ArrayList<>();
    private int purchaseAmount;
    private HashMap<Rank,Integer> lottoResult = new HashMap<>();

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
        return Math.round(getPrizeSum()/(double)purchaseAmount * roundIntConstatnt)/roundDoubleConstatnt;
    }
}
