package domain;

import java.util.EnumMap;
import java.util.Map;

public class LottoResult {
    private final Map <LottoRank,Integer> result = new EnumMap <>(LottoRank.class);

    public LottoResult(LotteryMachine lotteryMachine, WinningNumber winningNumber){
        for(Lotto lotto : lotteryMachine.getLottos()){
            System.out.println("==== 한개씩 결과 ====");
            System.out.println(lotto.sameNumberCount(winningNumber));
        }
    }

}
