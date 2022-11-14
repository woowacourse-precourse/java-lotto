package lotto;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

public class LottoStats {
    private Map<StatsType,Integer> lottoStats = new LinkedHashMap<>();
    private final Double POINT_CONST = 100.0;
    private final Integer PERCENT = 100;
    private Double earning = 0d;
    public LottoStats() {
        StatsType[] types = StatsType.values();
        lottoStats.put(StatsType.five,0);
        lottoStats.put(StatsType.four,0);
        lottoStats.put(StatsType.third,0);
        lottoStats.put(StatsType.second,0);
        lottoStats.put(StatsType.first,0);

    }
    private void calculationEarning(Integer cost){
        earning = 0d;
        for(var type  : lottoStats.keySet()){
            earning += type.getMoney() * lottoStats.get(type);
        }
        earning /= cost;
        earning *= PERCENT;
        earning = Math.round(earning * POINT_CONST) / POINT_CONST;
    }

    public void calculationStats(Purchase purchaseLotto , Lotto winningNumber , Integer bonus){
        for(int i = 0;i<purchaseLotto.getMyLotto().size();i++){
            Lotto lotto = purchaseLotto.getMyLotto().get(i);
            Optional<StatsType> optionalStatType = compareLotto(lotto,winningNumber,bonus);
            if(optionalStatType.isPresent()) {
                StatsType statType = optionalStatType.get();
                lottoStats.put(statType, lottoStats.get(statType) + 1);
            }
        }
        calculationEarning(purchaseLotto.getCost());
    }

    private Optional<StatsType> compareLotto(Lotto lotto,Lotto winningNumber,Integer bonus){
        Long score = lotto.sameNumber(winningNumber,bonus);
        return Arrays.stream(StatsType.values())
                .filter(type -> type.getScore() == score)
                .findFirst();
    }

}
