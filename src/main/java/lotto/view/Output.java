package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Win;
import lotto.utils.LottoStatistics;

import java.util.List;

import static lotto.LottoRank.*;

public class Output {

    private Output() {}


    public static void outputLottoList(int lottoCount, List<Lotto> lottos) {
        System.out.println("\n" + lottoCount + "개를 구매했습니다.");
        lottos.forEach(Lotto::printNumbers);
    }

    public static void outputWinningStats(int cost, List<Lotto> lottos, Win win) {
        System.out.println("\n당첨 통계");
        System.out.println("---");
        LottoStatistics lottoStatistics = new LottoStatistics(lottos, win);
        System.out.println(FIFTH + " - " + lottoStatistics.getFifthCount() + "개");
        System.out.println(FOURTH + " - " + lottoStatistics.getFourthCount() + "개");
        System.out.println(THIRD + " - " + lottoStatistics.getThirdCount() + "개");
        System.out.println(SECOND + " - " + lottoStatistics.getSecondCount() + "개");
        System.out.println(FIRST + " - " + lottoStatistics.getFirstCount() + "개");

        System.out.println("총 수익률은 " + lottoStatistics.getRateOfResult(cost) + "%입니다.");
    }


}
