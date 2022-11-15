package domain;

import view.OutputView;

import java.util.EnumMap;
import java.util.Map;

public class LottoResult {
    private final Map <LottoRank,Integer> result = LottoRank.initializeMap();

    public LottoResult(LotteryMachine lotteryMachine, WinningNumber winningNumber){
        for(Lotto lotto : lotteryMachine.getLottos()){
            LottoRank lottoRank = LottoRank.findRank(lotto.sameNumberCount(winningNumber),
                    lotto.containBonusNumber(winningNumber));
            result.put(lottoRank, result.getOrDefault(lottoRank, 0) +1);
        }
        OutputView.showResult(result);
    }

    public Map<LottoRank, Integer> getResult(){
        return this.result;
    }
}
