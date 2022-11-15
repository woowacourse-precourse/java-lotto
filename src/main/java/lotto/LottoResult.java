package lotto;

import java.util.List;

public class LottoResult {
    private long totalPrize = 0;
    private final int[] rankCount = new int[6];
    private static String MORE_THAN_ONE = "로또를 하나 이상 사야 합니다.";

    public void update(LottoRank lottoRank){
        rankCount[lottoRank.getRank()]++;
        totalPrize += lottoRank.getPrize();
    }

    public void updateLotto(List<LottoRank> ranks){
        for(LottoRank rank : ranks){
            update(rank);
        }
    }

    public int getNumOfRank(LottoRank rank){
        return rankCount[rank.getRank()];
    }

    public long getPrize(){
        if(totalPrize==0 && rankCount[0]==0){
            throw new IllegalArgumentException(MORE_THAN_ONE);
        }
        return totalPrize;
    }
}
