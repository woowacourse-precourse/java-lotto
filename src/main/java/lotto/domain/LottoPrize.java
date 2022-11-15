package lotto.domain;

import java.util.Map;

import static lotto.domain.LottoResult.FOUR;
import static lotto.domain.LottoResult.THREE;
import static lotto.domain.LottoResult.FIVE;
import static lotto.domain.LottoResult.FIVE_BONUS;
import static lotto.domain.LottoResult.SIX;

public class LottoPrize {

    public float calculateEarning(int lottoPrice) {
        return ((float) addPrize() / (float) lottoPrice) * 100;
    }
    private int addPrize(){
        Map<LottoResult,Integer>  lottoResultMap = LottoStatistics.getLottoResultMap();
        int total = 0;
        for ( LottoResult key : lottoResultMap.keySet() ) {
            if (key == THREE) total+= key.getPrize() * lottoResultMap.get(key);
            else if (key == FOUR) total += key.getPrize() * lottoResultMap.get(key);
            else if (key == FIVE) total += key.getPrize() * lottoResultMap.get(key);
            else if (key == FIVE_BONUS) total += key.getPrize() * lottoResultMap.get(key);
            else if (key == SIX) total += key.getPrize() * lottoResultMap.get(key);
        }
        return total;
    }
}
