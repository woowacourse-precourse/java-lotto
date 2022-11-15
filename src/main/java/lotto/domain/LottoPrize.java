package lotto.domain;

import java.util.Map;

public class LottoPrize {

    public double calculateEarning(int lottoPrice) {
        return (double) addPrize() / lottoPrice * 100;
    }

    private int addPrize(){
        Map<LottoResult,Integer>  lottoResultMap = LottoStatistics.getLottoResultMap();
        int total = lottoResultMap.keySet()
                .stream()
                .map(key -> key.getPrize() * lottoResultMap.get(key))
                .mapToInt(prize -> (int) prize)
                .reduce(0,Integer::sum);
        return total;
    }
}
