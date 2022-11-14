package lotto.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {

    private int rewardAmount;
    private int purchaseAmount;
    private int ticketNumber;
    private Map<String, Integer> rankMap = new HashMap<>();
    private final List<LottoRank> lottoRanks;

    public LottoResult(List<LottoRank> lottoRanks) {
        this.lottoRanks = lottoRanks;
        ticketNumber = lottoRanks.size();
        purchaseAmount = ticketNumber * 1000;
        rewardAmount = 0;
        initMap();
        calcResult();
    }

    public void initMap() {
        rankMap.put(LottoRank.LOSE.name(), 0);
        rankMap.put(LottoRank.FIFTH.name(), 0);
        rankMap.put(LottoRank.FOURTH.name(), 0);
        rankMap.put(LottoRank.THIRD.name(), 0);
        rankMap.put(LottoRank.SECOND.name(), 0);
        rankMap.put(LottoRank.FIRST.name(), 0);
    }

    public void calcResult() {
        for (LottoRank rank : lottoRanks) {
            rewardAmount += rank.getReward();
            int beforeValue = rankMap.get(rank.name());
            rankMap.put(rank.name(), beforeValue + 1);
        }
    }

    public int getLose() {
        return rankMap.get(LottoRank.LOSE.name());
    }

    public int getFifth() {
        return rankMap.get(LottoRank.FIFTH.name());
    }

    public int getFourth() {
        return rankMap.get(LottoRank.FOURTH.name());
    }

    public int getThird() {
        return rankMap.get(LottoRank.THIRD.name());
    }

    public int getSecond() {
        return rankMap.get(LottoRank.SECOND.name());
    }

    public int getFirst() {
        return rankMap.get(LottoRank.FIRST.name());
    }
}
