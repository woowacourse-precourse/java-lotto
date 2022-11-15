package lotto;

import java.util.Map;

public class LottoStatistics {

    private final Map<LottoResult, Integer> lottoResultNumberMap;
    private final double rateOfReturn;

    public LottoStatistics(Map<LottoResult, Integer> lottoResultNumberMap, double rateOfReturn) {
        this.lottoResultNumberMap = lottoResultNumberMap;
        this.rateOfReturn = rateOfReturn;
    }


    public double getRateOfReturn() {
        return rateOfReturn;
    }

    public int getHowManyPeopleInSpecificRanking(LottoResult rank) {
        return lottoResultNumberMap.get(rank);
    }
}
