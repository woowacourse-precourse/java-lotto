package lotto;

import java.util.*;

public class ResultLotto {
    CoreProcess core = new CoreProcess();
    InOutPut bring = new InOutPut();
    winPrizeResult result = new winPrizeResult();

    public ResultLotto(int moneyChance, List<Integer> Lotto,List<List<Integer>> lottoPack,int bonus) {
        int PRIZE_RESULT = 0;
        for(int j = 0; j < lottoPack.size(); j++){
            int count = core.compareNumber(lottoPack.get(j), Lotto);
            winPrize value = core.setResult(count, core.checkBonus(lottoPack.get(j), bonus));
            result.winPrizeCount(value);
            int earning = core.setResult(count, core.checkBonus(lottoPack.get(j), bonus)).prize;
            PRIZE_RESULT += earning;
        }

        List<Integer> outcome = result.resultCount();
        System.out.println(outcome);
        int earningRatio = core.earningRatio(moneyChance, PRIZE_RESULT);
        double earnings = Math.round(earningRatio*100)/100.0;
        System.out.println(earnings);
        bring.resultLotto(outcome, earnings);

    }
}

