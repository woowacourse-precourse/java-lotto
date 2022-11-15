package domain;

import view.OutputView;

import java.util.EnumMap;
import java.util.Map;
import java.util.stream.Stream;

public class LottoResult {
    private final Map <LottoRank,Integer> result = LottoRank.initializeMap();

    public LottoResult(LotteryMachine lotteryMachine, WinningNumber winningNumber){
        for(Lotto lotto : lotteryMachine.getLottos()){
            LottoRank lottoRank = LottoRank.findRank(lotto.sameNumberCount(winningNumber),
                    lotto.containBonusNumber(winningNumber));
            result.put(lottoRank, result.getOrDefault(lottoRank, 0) +1);
        }
    }

    public double profitPercent(int purchaseMoney){
        return (double) allWinning() / purchaseMoney;
    }

    private long allWinning() {
        return result.entrySet().stream().filter(e -> e.getValue() >= 1
        ).map(e -> e.getKey().getPrize() * e.getValue()).mapToLong(e -> e).sum();
    }

    public Map<LottoRank, Integer> getResult(){
        return this.result;
    }
}
