package lotto.domain;

import java.util.ArrayList;
import java.util.HashMap;

public class Buyer {
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
}
