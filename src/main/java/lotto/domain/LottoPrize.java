package lotto.domain;

import java.util.Map;

import static lotto.domain.LottoResult.FOUR;
import static lotto.domain.LottoResult.THREE;
import static lotto.domain.LottoResult.FIVE;
import static lotto.domain.LottoResult.FIVE_BONUS;
import static lotto.domain.LottoResult.SIX;

public class LottoPrize {
    private static final int GET_FIFTH_RANKING_PRIZE = 5000;
    private static final int GET_FOURTH_RANKING_PRIZE = 50000;
    private static final int GET_THIRD_RANKING_PRIZE = 1500000;
    private static final int GET_SECOND_RANKING_PRIZE = 30000000;
    private static final int GET_FIRST_RANKING_PRIZE = 2000000000;

    public float calculateEarning(int lottoPrice) {
        return ((float) addPrize() / (float) lottoPrice) * 100;
    }
    private int addPrize(){
        Map<LottoResult,Integer>  lottoResultMap = LottoStatistics.getLottoResultMap();
        int total = 0;
        for ( LottoResult key : lottoResultMap.keySet() ) {
            if (key == THREE) total+= GET_FIFTH_RANKING_PRIZE * lottoResultMap.get(key);
            else if (key == FOUR) total += GET_FOURTH_RANKING_PRIZE * lottoResultMap.get(key);
            else if (key == FIVE) total += GET_THIRD_RANKING_PRIZE * lottoResultMap.get(key);
            else if (key == FIVE_BONUS) total += GET_SECOND_RANKING_PRIZE * lottoResultMap.get(key);
            else if (key == SIX) total += GET_FIRST_RANKING_PRIZE * lottoResultMap.get(key);
        }
        return total;
    }
}
