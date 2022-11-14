package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoRank;

import java.util.List;

public class ResultPrint {
    public void numberOfPurchase(int numberOfPurchase) {
        System.out.println(numberOfPurchase + "개를 구매했습니다.");
    }

    public void generateLotto(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getLotto());
        }
        System.out.println();
    }

    public void winningStatistics(List<Integer> lottoWinningCount) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + lottoWinningCount.get(LottoRank.FIVE.ordinal()) + "개");
        System.out.println("4개 일치 (50,000원) - " + lottoWinningCount.get(LottoRank.FOUR.ordinal()) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + lottoWinningCount.get(LottoRank.THREE.ordinal()) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + lottoWinningCount.get(LottoRank.TWO.ordinal()) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + lottoWinningCount.get(LottoRank.ONE.ordinal()) + "개");
    }
}
