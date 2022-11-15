package lotto.View;

import java.text.DecimalFormat;
import java.util.List;

public class OutputView {
    public void showPurchasedLotto(int purchasedCount, List<List<Integer>> purchasedLottoNumber){
        System.out.print(purchasedCount + "개를 구매했습니다.");
        for(List<Integer> lottoNumbers : purchasedLottoNumber){
            System.out.println(lottoNumbers.toString());
        }
    }

    public void showLottoPrize(List<List<Integer>> winCountByPrize){
        final int FIRSTRANK = 4, SECONDRANK = 3, THIRDRANK = 2, FOURTHRANK = 1, FIFTHRANK = 0;
        final int PRIZE = 0, WINCOUNT = 1;
        DecimalFormat df = new DecimalFormat("###,###");
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (" + df.format(winCountByPrize.get(FIFTHRANK).get(PRIZE)) + "원) - " + winCountByPrize.get(FIFTHRANK).get(WINCOUNT) + "개");
        System.out.println("4개 일치 (" + df.format(winCountByPrize.get(FOURTHRANK).get(PRIZE)) + "원) - " + winCountByPrize.get(FOURTHRANK).get(WINCOUNT) + "개");
        System.out.println("5개 일치 (" + df.format(winCountByPrize.get(THIRDRANK).get(PRIZE)) + "원) - " + winCountByPrize.get(THIRDRANK).get(WINCOUNT) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (" + df.format(winCountByPrize.get(SECONDRANK).get(PRIZE)) + "원) - " + winCountByPrize.get(SECONDRANK).get(WINCOUNT) + "개");
        System.out.println("6개 일치 (" + df.format(winCountByPrize.get(FIRSTRANK).get(PRIZE)) + "원) - " + winCountByPrize.get(FIRSTRANK).get(WINCOUNT) + "개");
    }

    public void showYield(double yield){
        System.out.println("총 수익률은 " + yield + "%입니다.");
    }
}