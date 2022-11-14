package lotto.view.output;

import lotto.domain.Lottos;
import lotto.domain.RankingType;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Guide {

    public void printInputPriceGuide() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void printLottoCount(long lottoCount) {
        System.out.printf("%d개를 구매했습니다.%n", lottoCount);
    }

    public void printInputWinningLottoGuide() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void printInputBonusGuide() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public void printLottoGroup(Lottos lottoGroup){
        System.out.println(lottoGroup.getLottosString());
    }

    public void printResultGuide(){
        System.out.println("당첨 통계\n---");
    }

    public void printResult(Map<RankingType, Integer> countByRankingType){
        ResultStatics resultStatics = new ResultStatics();
        System.out.println(resultStatics.getString(countByRankingType));
    }

    public void printProfitRate(double profitRate) {
        System.out.printf("총 수익률 : %.2f%%\n",profitRate);
    }
}
