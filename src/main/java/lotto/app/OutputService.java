package lotto.app;

import lotto.domain.LottoResult;
import lotto.domain.LottoReward;
import lotto.Rank;
import lotto.domain.Money;

import java.util.List;

public class OutputService {
    public void printNumbers(List<Integer> numbers){
        System.out.print("[" + numbers.get(0));
        for(int i = 1; i < 6; i++){
            System.out.print(", " + numbers.get(i));
        }
        System.out.println("]");
    }

    public void printResult(LottoResult lottoResult){
        System.out.println("당첨 통계\n" + "---");
        System.out.printf("3개 일치 (5,000원) - %d개\n", lottoResult.getRankNumber(Rank.FIFTH));
        System.out.printf("4개 일치 (50,000원) - %d개\n", lottoResult.getRankNumber(Rank.FOURTH));
        System.out.printf("5개 일치 (1,500,000원) - %d개\n", lottoResult.getRankNumber(Rank.THIRD));
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", lottoResult.getRankNumber(Rank.SECOND));
        System.out.printf("6개 일치 (2,000,000,000원) - %d개\n", lottoResult.getRankNumber(Rank.FIRST));
    }

    public void printRewardRate(Money money, LottoResult lottoResult, LottoReward lottoReward){
        lottoReward.setReward(lottoResult);
        System.out.printf("총 수익률은 %.1f%%입니다.", lottoReward.getRewardRate());
    }
}
